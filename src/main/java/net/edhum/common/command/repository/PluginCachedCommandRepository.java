package net.edhum.common.command.repository;

import com.google.inject.Inject;
import net.edhum.common.command.CommandTree;
import net.edhum.common.repository.AbstractPluginCachedRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PluginCachedCommandRepository extends AbstractPluginCachedRepository<CommandTree> implements CommandRepository {

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
    protected Collection<CommandTree> getValues() {
        return this.commands.values();
    }
}
