package net.edhum.common.command.repository.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.Command;
import net.edhum.common.command.CommandTree;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.command.sender.CommandSender;

import java.util.function.Predicate;

public class CommandSenderFilter implements Predicate<CommandTree> {

    private final CommandPermissionHandler commandPermissionHandler;
    private final CommandSender sender;

    @AssistedInject
    public CommandSenderFilter(CommandPermissionHandler commandPermissionHandler,
                               @Assisted CommandSender sender) {
        this.commandPermissionHandler = commandPermissionHandler;
        this.sender = sender;
    }

    @Override
    public boolean test(CommandTree command) {
        Command root = command.getRoot().getCommand();

        return this.commandPermissionHandler.canExecute(root, this.sender);
    }
}
