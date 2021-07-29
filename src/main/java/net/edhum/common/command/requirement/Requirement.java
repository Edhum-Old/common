package net.edhum.common.command.requirement;

import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.message.Message;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Requirement {

    Optional<Requirement> getParent();

    Predicate<CommandSender> getPredicate();

    Message getErrorMessage();
}
