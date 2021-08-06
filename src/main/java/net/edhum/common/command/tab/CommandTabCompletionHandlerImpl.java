package net.edhum.common.command.tab;

import com.google.inject.Inject;
import net.edhum.common.command.Command;
import net.edhum.common.command.CommandLineBuffer;
import net.edhum.common.command.CommandNode;
import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.command.sender.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommandTabCompletionHandlerImpl implements CommandTabCompletionHandler {

    private final CommandPermissionHandler commandPermissionHandler;

    @Inject
    public CommandTabCompletionHandlerImpl(CommandPermissionHandler commandPermissionHandler) {
        this.commandPermissionHandler = commandPermissionHandler;
    }

    @Override
    public List<String> handleTabCompletion(CommandNode node, CommandSender sender, CommandLineBuffer buffer) {
        Command command = node.getCommand();

        if (!this.commandPermissionHandler.canExecute(command, sender)) {
            return Collections.emptyList();
        }

        String argument = buffer.next();

        List<CommandNode> childNodes = node.getChildren().stream()
                .filter(childNode -> {
                    String childCommandName = childNode.getCommand().getName();

                    return childCommandName.equalsIgnoreCase(argument);
                })
                .toList();

        if (childNodes.size() > 1) {
            return Collections.emptyList(); // TODO Not sure
        }

        if (childNodes.size() == 1) {
            buffer.consume();

            CommandNode childNode = childNodes.get(0);

            return this.handleTabCompletion(childNode, sender, buffer);
        } else {
            List<CommandNode> matchingChildNodes = new ArrayList<>(node.getChildren().stream()
                    .filter(childNode -> {
                        Command childCommand = childNode.getCommand();

                        return childCommand.getName().startsWith(argument) && this.commandPermissionHandler.canExecute(childCommand, sender);
                    })
                    .toList());

            if (!matchingChildNodes.isEmpty()) {
                // Sender is tipping a command node
                return matchingChildNodes.stream()
                        .map(childNode -> childNode.getCommand().getName())
                        .sorted()
                        .toList();
            } else {
                // Sender is tipping an argument
                List<Argument> commandArguments = command.getArguments();

                String[] arguments = buffer.remains();

                long requiredCommandArguments = commandArguments.stream()
                        .filter(Argument::isRequired)
                        .count();

                if (arguments.length < requiredCommandArguments || arguments.length > commandArguments.size()) {
                    return Collections.emptyList();
                }

                // Sort the arguments list alphabetically
                return commandArguments.get(arguments.length - 1).getParser().tabComplete(sender).stream()
                        .filter(s -> s.startsWith(arguments[arguments.length - 1]))
                        .sorted()
                        .collect(Collectors.toList());
            }
        }
    }
}
