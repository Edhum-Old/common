package net.edhum.common.message.context.writer;

import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.message.Message;

import java.util.Collection;

public interface WriterContext {

    void write(Message message, Collection<? extends CommandSender> receivers) throws Exception;
}
