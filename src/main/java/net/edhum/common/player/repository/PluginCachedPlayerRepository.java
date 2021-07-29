package net.edhum.common.player.repository;

import com.google.inject.Inject;
import net.edhum.common.player.Player;
import net.edhum.common.repository.AbstractRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PluginCachedPlayerRepository extends AbstractRepository<Player> implements PlayerRepository {

    private final Map<UUID, Player> players;

    @Inject
    public PluginCachedPlayerRepository() {
        this.players = new HashMap<>();
    }

    @Override
    public void add(Player player) {
        if (this.players.containsKey(player.getUniqueId())) {
            throw new IllegalStateException("UUID already exists");
        }

        this.players.put(player.getUniqueId(), player);
    }

    @Override
    protected Collection<Player> getValues() {
        return this.players.values();
    }

    @Override
    public void remove(UUID uuid) {
        this.players.remove(uuid);
    }
}
