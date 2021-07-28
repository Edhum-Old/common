package net.edhum.common.persistence.sql;

import com.google.inject.Inject;
import net.edhum.common.persistence.sql.exception.SQLInitialisationException;
import net.edhum.common.plugin.annotations.PluginLogger;
import net.edhum.common.shutdown.ShutdownHooks;

import java.util.logging.Logger;

public class SQLPostExecutor {

    private final Logger logger;
    private final SQLAccess sqlAccess;
    private final ShutdownHooks shutdownHooks;

    @Inject
    public SQLPostExecutor(@PluginLogger Logger logger, SQLAccess sqlAccess, ShutdownHooks shutdownHooks) {
        this.logger = logger;
        this.sqlAccess = sqlAccess;
        this.shutdownHooks = shutdownHooks;
    }

    @Inject
    public void init() {
        try {
            this.sqlAccess.init();
            this.shutdownHooks.add(() -> {
                this.sqlAccess.close();

                this.logger.info("The SQL access was successfully closed");
            });

            this.logger.info("The SQL access was successfully initialised");
        } catch (SQLInitialisationException e) {
            e.printStackTrace();
        }
    }
}
