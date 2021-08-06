package net.edhum.common.command.execution.context;

import net.edhum.common.command.Command;
import net.edhum.common.command.sender.CommandSender;

public class CommandContext {

    private final Command command;
    private final CommandSender sender;

    public CommandContext(Command command,
                          CommandSender sender) {
        this.command = command;
        this.sender = sender;
    }

    public Command getCommand() {
        return this.command;
    }

    public CommandSender getSender() {
        return this.sender;
    }
}
