package net.edhum.common.player;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import net.edhum.common.player.repository.PlayerRepository;
import net.edhum.common.player.repository.PluginCachedPlayerRepository;
import net.edhum.common.player.repository.filter.NameFilter;
import net.edhum.common.player.repository.filter.PlayerRepositoryFilterFactory;
import net.edhum.common.player.repository.filter.UUIDFilter;

import java.util.function.Predicate;

public class PlayerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
                .implement(new TypeLiteral<Predicate<Player>>() {}, Names.named("name"), NameFilter.class)
                .implement(new TypeLiteral<Predicate<Player>>() {}, Names.named("uuid"), UUIDFilter.class)
                .build(PlayerRepositoryFilterFactory.class));

        bind(PlayerRepository.class).to(PluginCachedPlayerRepository.class).asEagerSingleton();
    }
}
