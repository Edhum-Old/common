package net.edhum.common.command.repository;

import com.google.inject.Inject;
import net.edhum.common.command.CommandTree;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PluginCachedCommandRepository implements CommandRepository {

    private final Map<String, CommandTree> commands;

    @Inject
    public PluginCachedCommandRepository() {
        this.commands = new HashMap<>();
    }

    @Override
    public void add(CommandTree command) {
        String name = command.getRoot().getCommand().getName();

        if (this.commands.containsKey(name)) {
            throw new IllegalStateException(
                    String.format("%s has already been registered", name)
            );
        }

        this.commands.put(name, command);
    }

    @Override
    public boolean contains(Predicate<CommandTree> predicate) {
        return this.find(predicate).isPresent();
    }

    @Override
    public Optional<CommandTree> find(Predicate<CommandTree> predicate) {
        return this.commands.values().stream()
                .filter(predicate)
                .findAny();
    }

    @Override
    public Collection<CommandTree> findAll(Predicate<CommandTree> predicate) {
        return this.commands.values().stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }

    @Override
    public void remove(String name) {
        if (!this.commands.containsKey(name)) {
            throw new IllegalArgumentException(String.format("No command with name %s has been found", name));
        }

        this.commands.remove(name);
    }
}
