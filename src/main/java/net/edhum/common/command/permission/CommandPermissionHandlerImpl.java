package net.edhum.common.command.permission;

import net.edhum.common.command.Command;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.command.sender.CommandSender;

import java.util.Optional;

public class CommandPermissionHandlerImpl implements CommandPermissionHandler {

    @Override
    public boolean checkPermissions(Command command, CommandSender sender) {
        return this.hasPermission(command, sender).isEmpty() && this.checkRequirements(command, sender).isEmpty();
    }

    @Override
    public Optional<String> hasPermission(Command command, CommandSender sender) {
        if (sender.hasPermission(command.getPermission())) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(command.getPermission());
        }
    }

    @Override
    public Optional<Requirement> checkRequirements(Command command, CommandSender sender) {
        for (Requirement requirement : command.getRequirements()) {
            Optional<Requirement> optionalRequirement = this.checkRequirements(requirement, sender);

            if (optionalRequirement.isPresent()) {
                return optionalRequirement;
            }
        }

        return Optional.empty();
    }

    private Optional<Requirement> checkRequirements(Requirement requirement, CommandSender sender) {
        Optional<Requirement> optionalParent = requirement.getParent();

        while (optionalParent.isPresent()) {
            Requirement parent = optionalParent.get();

            if (!parent.getPredicate().test(sender)) {
                return optionalParent;
            }

            optionalParent = parent.getParent();
        }

        return Optional.empty();
    }
}
