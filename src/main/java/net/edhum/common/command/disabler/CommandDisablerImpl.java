package net.edhum.common.command.disabler;

import com.google.inject.Inject;
import net.edhum.common.command.disabler.list.DisabledCommandList;
import net.edhum.common.command.disabler.list.DisabledCommandListProvider;
import net.edhum.common.command.disabler.list.UnavailableDisabledCommandList;
import net.edhum.common.command.registerer.CommandRegisterer;
import net.edhum.common.command.repository.CommandRepository;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CommandDisablerImpl implements CommandDisabler {

    private final DisabledCommandList disabledCommandList;
    private final CommandRepository commandRepository;
    private final CommandRegisterer commandRegisterer;

    @Inject
    public CommandDisablerImpl(@PluginLogger Logger logger, DisabledCommandListProvider disabledCommandListProvider, CommandRepository commandRepository, CommandRegisterer commandRegisterer) {
        DisabledCommandList disabledCommandList;

        try {
            disabledCommandList = disabledCommandListProvider.get();
        } catch (IOException e) {
            e.printStackTrace();
            logger.warning("An exception occurred while attempting to get the disabled commands. The default one will be used instead");

            disabledCommandList = UnavailableDisabledCommandList.getDefaultDisabledCommandList();
        }

        this.disabledCommandList = disabledCommandList;

        this.commandRepository = commandRepository;
        this.commandRegisterer = commandRegisterer;
    }

    @Override
    public void disableCommands() {
        List<String> disabledCommands = this.disabledCommandList.getDisabledCommands();

        for (String disabledCommand : disabledCommands) {
            this.commandRepository.remove(disabledCommand);
            this.commandRegisterer.unregisterCommand(disabledCommand);
        }
    }
}
