package net.edhum.common.message.context.receiver;

import net.edhum.common.command.sender.CommandSender;

import java.util.Collection;

public interface ReceiverContext {

    Collection<? extends CommandSender> getReceivers();
}
