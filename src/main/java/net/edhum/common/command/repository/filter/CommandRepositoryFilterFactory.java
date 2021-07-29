package net.edhum.common.command.repository.filter;

import net.edhum.common.command.CommandTree;
import net.edhum.common.command.sender.CommandSender;

import java.util.function.Predicate;

public interface CommandRepositoryFilterFactory {

    Predicate<CommandTree> name(String name);

    Predicate<CommandTree> commandSender(CommandSender sender);
}
