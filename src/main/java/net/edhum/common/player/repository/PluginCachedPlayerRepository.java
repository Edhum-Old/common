package net.edhum.common.player.repository;

import com.google.inject.Inject;
import net.edhum.common.player.Player;
import net.edhum.common.repository.AbstractPluginCachedRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PluginCachedPlayerRepository extends AbstractPluginCachedRepository<Player> implements PlayerRepository {

    private final Map<UUID, Player> players;

    @Inject
    public PluginCachedPlayerRepository() {
        this.players = new HashMap<>();
    }

    @Override
    public void add(Player player) {
        if (this.players.containsKey(player.getProfile().getUniqueId())) {
            throw new IllegalStateException("UUID already exists");
        }

        this.players.put(player.getProfile().getUniqueId(), player);
    }

    @Override
    public void remove(UUID uuid) {
        this.players.remove(uuid);
    }

    @Override
    protected Collection<Player> getValues() {
        return this.players.values();
    }
}
