package net.edhum.common.command;

import com.google.inject.Inject;
import net.edhum.common.command.disabler.CommandDisabler;
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
    private final DisabledCommandList disabledCommandList;
    private final CommandRegisterer commandRegisterer;
    private final CommandRepository commandRepository;
    private final CommandDisabler commandDisabler;

    @Inject
    public CommandPostExecutor(@PluginLogger Logger logger,
                               Set<CommandTree> commands,
                               DisabledCommandListProvider disabledCommandListProvider,
                               CommandRegisterer commandRegisterer,
                               CommandRepository commandRepository,
                               CommandDisabler commandDisabler) {
        this.logger = logger;
        this.commands = commands;

        DisabledCommandList disabledCommandList;

        try {
            disabledCommandList = disabledCommandListProvider.get();
        } catch (IOException e) {
            e.printStackTrace();
            logger.warning("An exception occurred while attempting to get the disabled commands. The default one will be used instead");

            disabledCommandList = UnavailableDisabledCommandList.getDefaultDisabledCommandList();
        }

        this.disabledCommandList = disabledCommandList;

        this.commandRegisterer = commandRegisterer;
        this.commandRepository = commandRepository;
        this.commandDisabler = commandDisabler;
    }

    public void init() {
        List<String> disabledCommands = this.disabledCommandList.getDisabledCommands();

        for (CommandTree command : commands) {
            String name = command.getRoot().getCommand().getName();

            if (!disabledCommands.contains(name)) {
                this.commandRegisterer.registerCommand(command);
                this.commandRepository.add(command);

                String root = command.getRoot().getCommand().getName();
                this.logger.info(String.format("Registered %s command successfully", root));
            }
        }

        this.commandDisabler.disableCommands();
    }
}
