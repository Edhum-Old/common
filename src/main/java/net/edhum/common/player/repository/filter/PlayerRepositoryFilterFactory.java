package net.edhum.common.player.repository.filter;

import java.util.UUID;

public interface PlayerRepositoryFilterFactory {

    NameFilter name(String name);

    UUIDFilter uuid(UUID uuid);
}
