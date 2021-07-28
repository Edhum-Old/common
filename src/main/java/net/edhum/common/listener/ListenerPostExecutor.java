package net.edhum.common.listener;

import com.google.inject.Inject;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.util.Set;
import java.util.logging.Logger;

public class ListenerPostExecutor<T> {

    private final Logger logger;
    private final Set<T> listeners;
    private final ListenerRegisterer<T> listenerRegisterer;

    @Inject
    public ListenerPostExecutor(@PluginLogger Logger logger,
                                Set<T> listeners,
                                ListenerRegisterer<T> listenerRegisterer) {
        this.logger = logger;
        this.listeners = listeners;
        this.listenerRegisterer = listenerRegisterer;
    }

    public void registerListeners() {
        for (T listener : this.listeners) {
            listenerRegisterer.registerListener(listener);

            this.logger.info(String.format("Registered %s listener successfully", listener.getClass().getSimpleName()));
        }
    }
}
