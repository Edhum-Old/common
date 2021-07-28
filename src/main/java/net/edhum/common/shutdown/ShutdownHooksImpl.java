package net.edhum.common.shutdown;

import com.google.inject.Inject;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShutdownHooksImpl implements ShutdownHooks {

    private final Logger logger;

    private final List<Runnable> hooks;

    @Inject
    public ShutdownHooksImpl(@PluginLogger Logger logger) {
        this.logger = logger;
        this.hooks = new ArrayList<>();
    }

    @Override
    public void add(Runnable hook) {
        this.hooks.add(hook);
    }

    @Override
    public void closeAll() {
        this.logger.info("Closing all hooks...");

        for (Runnable hook : this.hooks) {
            hook.run();
        }
    }
}
