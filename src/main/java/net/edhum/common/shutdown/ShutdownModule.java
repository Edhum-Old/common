package net.edhum.common.shutdown;

import com.google.inject.AbstractModule;

public class ShutdownModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ShutdownHooks.class).to(ShutdownHooksImpl.class).asEagerSingleton();
    }
}
