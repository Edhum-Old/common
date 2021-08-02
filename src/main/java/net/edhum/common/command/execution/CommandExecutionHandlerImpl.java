package net.edhum.common.command.execution;

import com.google.inject.Inject;
import net.edhum.common.command.Command;
import net.edhum.common.command.CommandNode;
import net.edhum.common.command.CommandLineBuffer;
import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.argument.ArgumentParser;
import net.edhum.common.command.argument.exception.ArgumentException;
import net.edhum.common.command.execution.buffer.ArgumentBuffer;
import net.edhum.common.command.execution.buffer.ArgumentBufferFactory;
import net.edhum.common.command.execution.context.CommandContext;
import net.edhum.common.command.execution.exceptions.*;
import net.edhum.common.command.execution.result.CommandResult;
import net.edhum.common.command.execution.result.CommandResultHandler;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.command.sender.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandExecutionHandlerImpl implements CommandExecutionHandler {

    private final CommandPermissionHandler commandPermissionHandler;
    private final ArgumentBufferFactory argumentBufferFactory;
    private final CommandResultHandler commandResultHandler;

    @Inject
    public CommandExecutionHandlerImpl(CommandPermissionHandler commandPermissionHandler,
                                       ArgumentBufferFactory argumentBufferFactory,
                                       CommandResultHandler commandResultHandler) {
        this.commandPermissionHandler = commandPermissionHandler;
        this.argumentBufferFactory = argumentBufferFactory;
        this.commandResultHandler = commandResultHandler;
    }

    @Override
    public void handleExecution(CommandNode node, CommandSender sender, CommandLineBuffer buffer) throws ArgumentException, UnknownNodeException, InvalidPermissionException, InvalidRequirementException, InvalidSyntaxException {
        Command command = node.getCommand();

        Optional<String> optionalInvalidPermission = this.commandPermissionHandler.hasPermission(command, sender);

        if (optionalInvalidPermission.isPresent()) {
            throw new InvalidPermissionException(optionalInvalidPermission.get());
        }

        Optional<Requirement> optionalInvalidRequirement = this.commandPermissionHandler.checkRequirements(command, sender);

        if (optionalInvalidRequirement.isPresent()) {
            throw new InvalidRequirementException(optionalInvalidRequirement.get());
        }

        List<CommandNode> childNodes = new ArrayList<>();

        if (!buffer.isEmpty()) {
            childNodes = node.getChildren().stream()
                    .filter(childNode -> {
                        String argument = buffer.next();
                        Command childCommand = childNode.getCommand();

                        return childCommand.getName().equalsIgnoreCase(argument) || childCommand.getAliases().contains(argument);
                    })
                    .toList();

            if (node.hasChildren() && childNodes.isEmpty()) {
                throw new UnknownNodeException(node);
            }
        }

        if (!childNodes.isEmpty()) {
            buffer.consume();

            if (childNodes.size() > 1) {
                // Ambiguous nodes
                throw new AmbiguousNodesException(childNodes);
            }

            CommandNode childNode = childNodes.get(0);
            this.handleExecution(childNode, sender, buffer);
        } else {
            List<Argument> commandArguments = command.getArguments();

            String[] arguments = buffer.remains();

            long requiredArguments = commandArguments.stream()
                    .filter(Argument::isRequired)
                    .count();

            if (arguments.length < requiredArguments || arguments.length > commandArguments.size()) {
                throw new InvalidSyntaxException(node);
            }

            List<Object> parsedArguments = new ArrayList<>();

            for (int i = 0; i < arguments.length; i++) {
                String argument = arguments[i];

                ArgumentParser<?> commandArgumentParser = commandArguments.get(i).getParser();

                Object parsedArgument = commandArgumentParser.get(sender, argument);
                parsedArguments.add(parsedArgument);
            }

            CommandContext context = new CommandContext(command, sender);
            ArgumentBuffer argumentBuffer = this.argumentBufferFactory.createArgumentBuffer(parsedArguments);

            CommandResult result = command.getExecutor().execute(context, argumentBuffer);

            this.commandResultHandler.handleResult(result);
        }
    }
}
