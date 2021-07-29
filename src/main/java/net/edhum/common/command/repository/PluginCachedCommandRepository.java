package net.edhum.common.command.repository;

import com.google.inject.Inject;
import net.edhum.common.command.CommandTree;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PluginCachedCommandRepository implements CommandRepository {

    private final Set<CommandTree> commands;

    @Inject
    public PluginCachedCommandRepository() {
        this.commands = new HashSet<>();
    }

    @Override
    public void add(CommandTree command) {
        if (this.commands.contains(command)) {
            String root = command.getRoot().getCommand().getName();

            throw new IllegalStateException(
                    String.format("%s has already been registered", root)
            );
        }

        this.commands.add(command);
    }

    @Override
    public boolean contains(Predicate<CommandTree> filter) {
        return this.find(filter).isPresent();
    }

    @Override
    public Optional<CommandTree> find(Predicate<CommandTree> filter) {
        return this.commands.stream()
                .filter(filter)
                .findAny();
    }

    @Override
    public Set<CommandTree> findAll(Predicate<CommandTree> filter) {
        return this.commands.stream()
                .filter(filter)
                .collect(Collectors.toUnmodifiableSet());
    }
}
