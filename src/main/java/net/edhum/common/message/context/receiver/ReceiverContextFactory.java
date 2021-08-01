package net.edhum.common.message.context.receiver;

import net.edhum.common.player.Player;

import javax.inject.Named;
import java.util.Collection;
import java.util.UUID;

public interface ReceiverContextFactory {

    @Named("single")
    ReceiverContext single(Player receiver);

    @Named("single")
    ReceiverContext single(UUID receiver);

    @Named("broadcast")
    ReceiverContext broadcast(Collection<Player> excepts);

    @Named("broadcast")
    ReceiverContext broadcast(Player excepts);

    @Named("broadcast")
    ReceiverContext broadcast();
}