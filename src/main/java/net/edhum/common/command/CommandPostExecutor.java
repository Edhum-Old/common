package net.edhum.common.command;

import com.google.inject.Inject;
import net.edhum.common.command.registerer.CommandRegisterer;
import net.edhum.common.command.repository.CommandRepository;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.util.Set;
import java.util.logging.Logger;

public class CommandPostExecutor {

    private final Logger logger;
    private final Set<CommandTree> commands;
    private final CommandRegisterer registerer;
    private final CommandRepository repository;

    @Inject
    public CommandPostExecutor(@PluginLogger Logger logger,
                               Set<CommandTree> commands,
                               CommandRegisterer registerer,
                               CommandRepository repository) {
        this.logger = logger;
        this.commands = commands;
        this.registerer = registerer;
        this.repository = repository;
    }

    public void init() {
        for (CommandTree command : commands) {
            this.registerer.registerCommand(command);
            this.repository.add(command);

            String root = command.getRoot().getCommand().getName();
            this.logger.info(String.format("Registered %s command successfully", root));
        }
    }
}
