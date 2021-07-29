package net.edhum.common.command.repository.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.Command;
import net.edhum.common.command.CommandTree;
import net.edhum.common.command.permission.CommandPermissionHandler;
import net.edhum.common.player.Player;

import java.util.function.Predicate;

public class CommandSenderFilter implements Predicate<CommandTree> {

    private final CommandPermissionHandler commandPermissionHandler;
    private final Player player;

    @AssistedInject
    public CommandSenderFilter(CommandPermissionHandler commandPermissionHandler,
                               @Assisted Player player) {
        this.commandPermissionHandler = commandPermissionHandler;
        this.player = player;
    }

    @Override
    public boolean test(CommandTree command) {
        Command root = command.getRoot().getCommand();

        return this.commandPermissionHandler.checkPermissions(root, player);
    }
}
