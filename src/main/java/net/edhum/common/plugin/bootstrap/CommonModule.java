package net.edhum.common.plugin.bootstrap;

import com.google.inject.AbstractModule;
import net.edhum.common.configuration.ConfigurationModule;
import net.edhum.common.persistence.PersistenceModule;
import net.edhum.common.shutdown.ShutdownModule;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ConfigurationModule());
        install(new PersistenceModule());
        install(new ShutdownModule());
    }
}
