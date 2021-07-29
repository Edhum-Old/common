package net.edhum.common.command.tab;

import com.google.inject.Inject;
import net.edhum.common.command.Command;
import net.edhum.common.command.CommandNode;
import net.edhum.common.command.StringBuffer;
import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.command.sender.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandTabCompletionHandlerImpl implements CommandTabCompletionHandler {

    private final CommandPermissionHandler commandPermissionHandler;

    @Inject
    public CommandTabCompletionHandlerImpl(CommandPermissionHandler commandPermissionHandler) {
        this.commandPermissionHandler = commandPermissionHandler;
    }

    @Override
    public List<String> handleTabCompletion(CommandNode node, CommandSender sender, StringBuffer buffer) {
        Command command = node.getCommand();

        if (!this.commandPermissionHandler.checkPermissions(command, sender)) {
            return Collections.emptyList();
        }

        String argument = buffer.next();

        List<CommandNode> childNodes = node.getChildren().stream()
                .filter(childNode -> {
                    Command childCommand = node.getCommand();

                    return childCommand.getName().equalsIgnoreCase(argument);
                })
                .toList();

        if (childNodes.size() > 1) {
            return Collections.emptyList(); // TODO Not sure
        }

        if (childNodes.size() == 1) {
            CommandNode childNode = childNodes.get(0);

            return this.handleTabCompletion(childNode, sender, buffer);
        } else {
            List<String> nodesTabCompletion = new ArrayList<>(node.getChildren().stream()
                    .filter(childNode -> {
                        Command childCommand = childNode.getCommand();

                        return childCommand.getName().startsWith(argument) && this.commandPermissionHandler.checkPermissions(childCommand, sender);
                    })
                    .map(childNode -> childNode.getCommand().getName())
                    .toList());

            Collections.sort(nodesTabCompletion); // Sort the nodes list alphabetically

            List<String> argumentsTabCompletion = new ArrayList<>();

            List<Argument> commandArguments = command.getArguments();

            String[] arguments = buffer.remains();

            long requiredCommandArguments = commandArguments.stream()
                    .filter(Argument::isRequired)
                    .count();

            if (arguments.length > requiredCommandArguments && arguments.length < commandArguments.size()) {
                argumentsTabCompletion.addAll(commandArguments.get(arguments.length - 1).getParser().tabComplete(sender).stream()
                        .filter(s ->
                                s.startsWith(arguments[arguments.length - 1]))
                        .collect(Collectors.toList()));
            }

            Collections.sort(argumentsTabCompletion); // Sort the arguments list alphabetically

            return Stream.concat(nodesTabCompletion.stream(), argumentsTabCompletion.stream()).toList();
        }
    }
}
