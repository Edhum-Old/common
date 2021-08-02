package net.edhum.common.message.context.receiver;

import net.edhum.common.command.sender.CommandSender;

import javax.inject.Named;

public interface ReceiverContextFactory {

    @Named("single")
    ReceiverContext single(CommandSender receiver);
}