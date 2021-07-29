package net.edhum.common.command.permission;

import net.edhum.common.command.Command;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.command.sender.CommandSender;

import java.util.Optional;

public interface CommandPermissionHandler {

    boolean checkPermissions(Command command, CommandSender sender);

    Optional<String> hasPermission(Command command, CommandSender sender);

    Optional<Requirement> checkRequirements(Command command, CommandSender sender);
}
