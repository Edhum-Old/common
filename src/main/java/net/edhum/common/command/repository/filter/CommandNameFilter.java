package net.edhum.common.command.repository.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.CommandTree;

import java.util.function.Predicate;

public class CommandNameFilter implements Predicate<CommandTree> {

    private final String name;

    @AssistedInject
    public CommandNameFilter(@Assisted String name) {
        this.name = name;
    }

    @Override
    public boolean test(CommandTree tree) {
        return tree.getRoot().getCommand().getName().equalsIgnoreCase(this.name);
    }
}
