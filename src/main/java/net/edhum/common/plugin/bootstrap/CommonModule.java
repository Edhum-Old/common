package net.edhum.common.plugin.bootstrap;

import com.google.inject.AbstractModule;
import net.edhum.common.command.CommandModule;
import net.edhum.common.configuration.ConfigurationModule;
import net.edhum.common.i18n.InternalisationModule;
import net.edhum.common.message.MessageModule;
import net.edhum.common.persistence.PersistenceModule;
import net.edhum.common.player.PlayerModule;
import net.edhum.common.shutdown.ShutdownModule;

public class CommonModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new CommandModule());
        install(new ConfigurationModule());
        install(new InternalisationModule());
        install(new MessageModule());
        install(new PersistenceModule());
        install(new PlayerModule());
        install(new ShutdownModule());
    }
}
