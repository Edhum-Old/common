package net.edhum.common.command.repository.filter;

import net.edhum.common.command.CommandTree;
import net.edhum.common.command.sender.CommandSender;

import javax.inject.Named;
import java.util.function.Predicate;

public interface CommandRepositoryFilterFactory {

    @Named("name") Predicate<CommandTree> name(String name);

    @Named("sender") Predicate<CommandTree> sender(CommandSender sender);
}
