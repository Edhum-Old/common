package net.edhum.common.message.context.writer;

import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.message.MessagePath;

import java.util.Collection;

public interface WriterContext {

    void write(MessagePath context, Collection<? extends CommandSender> receivers) throws Exception;
}
