package net.edhum.common.message.context.receiver;

import net.edhum.common.player.Player;

import javax.inject.Named;
import java.util.Collection;
import java.util.UUID;

public interface ReceiverContextFactory {

    @Named("single")
    ReceiverContext singleReceiver(Player receiver);

    @Named("single")
    ReceiverContext singleReceiver(UUID receiver);

    @Named("broadcast")
    ReceiverContext broadcastReceiver(Collection<Player> excepts);

    @Named("broadcast")
    ReceiverContext broadcastReceiver(Player excepts);

    @Named("broadcast")
    ReceiverContext broadcastReceiver();
}