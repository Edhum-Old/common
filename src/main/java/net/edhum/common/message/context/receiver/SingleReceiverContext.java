package net.edhum.common.message.context.receiver;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.player.Player;
import net.edhum.common.player.repository.PlayerRepository;
import net.edhum.common.player.repository.filter.PlayerRepositoryFilterFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class SingleReceiverContext implements ReceiverContext {

    private final Player receiver;

    @AssistedInject
    public SingleReceiverContext(@Assisted Player receiver) {
        this.receiver = receiver;
    }

    @AssistedInject
    public SingleReceiverContext(PlayerRepository playerRepository,
                                 PlayerRepositoryFilterFactory playerRepositoryFilterFactory,
                                 @Assisted UUID receiver) {
        this(playerRepository.find(playerRepositoryFilterFactory.uuid(receiver))
                .orElseThrow(() -> new IllegalArgumentException("Invalid uuid")));
    }

    @Override
    public Collection<Player> getReceivers() {
        return Collections.singleton(this.receiver);
    }
}
