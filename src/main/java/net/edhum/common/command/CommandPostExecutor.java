package net.edhum.common.command;

import com.google.inject.Inject;
import net.edhum.common.command.disabler.list.DisabledCommandList;
import net.edhum.common.command.disabler.list.DisabledCommandListProvider;
import net.edhum.common.command.disabler.list.UnavailableDisabledCommandList;
import net.edhum.common.command.registerer.CommandRegisterer;
import net.edhum.common.command.repository.CommandRepository;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class CommandPostExecutor {

    private final Logger logger;
    private final Set<CommandTree> commands;
    private final CommandRegisterer commandRegisterer;
    private final CommandRepository commandRepository;

    @Inject
    public CommandPostExecutor(@PluginLogger Logger logger,
                               Set<CommandTree> commands,
                               CommandRegisterer commandRegisterer,
                               CommandRepository commandRepository) {
        this.logger = logger;
        this.commands = commands;
        this.commandRegisterer = commandRegisterer;
        this.commandRepository = commandRepository;
    }

    public void init() {
        for (CommandTree command : commands) {
            this.commandRegisterer.registerCommand(command);
            this.commandRepository.add(command);

            String root = command.getRoot().getCommand().getName();
            this.logger.info(String.format("Registered %s command successfully", root));
        }
    }
}
