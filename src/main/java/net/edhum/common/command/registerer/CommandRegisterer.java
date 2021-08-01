package net.edhum.common.command.registerer;

import net.edhum.common.command.CommandTree;

public interface CommandRegisterer {

    void registerCommand(CommandTree command);

    void unregisterCommand(String command);
}
