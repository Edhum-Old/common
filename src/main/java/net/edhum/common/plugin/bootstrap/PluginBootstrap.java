package net.edhum.common.plugin.bootstrap;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.edhum.common.persistence.sql.SQLAccess;
import net.edhum.common.persistence.sql.exception.SQLInitialisationException;
import net.edhum.common.plugin.ModularPlugin;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PluginBootstrap {

    public Injector bootstrap(ModularPlugin plugin) throws SQLInitialisationException {
        Injector injector = Guice.createInjector(plugin.getStage(),
                Stream.concat(
                        Stream.of(new CommonModule()),
                        plugin.getModules().stream()
                ).collect(Collectors.toList()));

        injector.getInstance(SQLAccess.class).init();

        return injector;
    }
}
