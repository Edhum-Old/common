package net.edhum.common.player.repository;

import net.edhum.common.player.Player;
import net.edhum.common.repository.Repository;

import java.util.UUID;

public interface PlayerRepository extends Repository<Player> {

    void add(Player player);

    void remove(UUID uuid);
}
