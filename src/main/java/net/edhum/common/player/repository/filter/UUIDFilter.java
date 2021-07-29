package net.edhum.common.player.repository.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.player.Player;

import java.util.UUID;
import java.util.function.Predicate;

public class UUIDFilter implements Predicate<Player> {

    private final UUID uuid;

    @AssistedInject
    public UUIDFilter(@Assisted UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean test(Player player) {
        return player.getUniqueId().equals(this.uuid);
    }
}
