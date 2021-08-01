package net.edhum.common.command.disabler;

import com.google.inject.Inject;
import net.edhum.common.command.disabler.list.DisabledCommandList;
import net.edhum.common.command.disabler.list.DisabledCommandListProvider;
import net.edhum.common.command.disabler.list.UnavailableDisabledCommandList;
import net.edhum.common.command.registerer.CommandRegisterer;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class CommandDisablerImpl implements CommandDisabler {

    private final CommandRegisterer commandRegisterer;
    private final DisabledCommandList disabledCommands;

    @Inject
    public CommandDisablerImpl(@PluginLogger Logger logger, CommandRegisterer commandRegisterer, DisabledCommandListProvider disabledCommandListProvider) {
        this.commandRegisterer = commandRegisterer;

        DisabledCommandList disabledCommands;

        try {
            disabledCommands = disabledCommandListProvider.get();
        } catch (IOException e) {
            e.printStackTrace();
            logger.warning("An exception occurred while attempting to get the disabled commands. The default one will be used instead");

            disabledCommands = UnavailableDisabledCommandList.getDefaultDisabledCommandList();
        }

        this.disabledCommands = disabledCommands;
    }

    @Override
    public void disableCommands() {
        List<String> disabledCommands = this.disabledCommands.getDisabledCommands();

        for (String disabledCommand : disabledCommands) {
            this.commandRegisterer.unregisterCommand(disabledCommand);
        }
    }
}
