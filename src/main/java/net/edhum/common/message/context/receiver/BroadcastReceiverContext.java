package net.edhum.common.message.context.receiver;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.player.Player;
import net.edhum.common.player.repository.PlayerRepository;

import java.util.Collection;
import java.util.Collections;

public class BroadcastReceiverContext implements ReceiverContext {

    private final PlayerRepository playerRepository;
    private final Collection<Player> blacklisted;

    @AssistedInject
    public BroadcastReceiverContext(PlayerRepository playerRepository,
                                    @Assisted Collection<Player> blacklisted) {
        this.playerRepository = playerRepository;

        this.blacklisted = blacklisted;
    }

    @AssistedInject
    public BroadcastReceiverContext(PlayerRepository playerRepository,
                                    @Assisted Player except) {
        this(playerRepository, Collections.singleton(except));
    }

    @AssistedInject
    public BroadcastReceiverContext(PlayerRepository playerRepository) {
        this(playerRepository, Collections.emptySet());
    }

    @Override
    public Collection<? extends CommandSender> getReceivers() {
        return this.playerRepository.findAll(player -> !this.blacklisted.contains(player));
    }
}
