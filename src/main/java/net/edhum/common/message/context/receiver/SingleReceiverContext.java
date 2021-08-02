package net.edhum.common.message.context.receiver;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.sender.CommandSender;

import java.util.Collection;
import java.util.Collections;

public class SingleReceiverContext implements ReceiverContext {

    private final CommandSender receiver;

    @AssistedInject
    public SingleReceiverContext(@Assisted CommandSender receiver) {
        this.receiver = receiver;
    }

    @Override
    public Collection<? extends CommandSender> getReceivers() {
        return Collections.singleton(this.receiver);
    }
}
