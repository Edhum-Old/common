package net.edhum.common.persistence.sql;

import com.google.inject.Inject;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import net.edhum.common.persistence.sql.credentials.SQLCredentials;
import net.edhum.common.persistence.sql.credentials.SQLCredentialsProvider;
import net.edhum.common.persistence.sql.credentials.UnavailableSQLCredentials;
import net.edhum.common.persistence.sql.exception.SQLInitialisationException;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class SQLPoolAccess implements SQLAccess {

    private final SQLCredentials credentials;
    private HikariDataSource dataSource;

    @Inject
    public SQLPoolAccess(@PluginLogger Logger logger, SQLCredentialsProvider credentialsProvider) {
        SQLCredentials credentials;

        try {
            credentials = credentialsProvider.get();
        } catch (Exception e) {
            e.printStackTrace();

            logger.warning("An exception has occurred while trying to read the redis credentials file." +
                    "The default redis credentials will be used.");

            credentials = UnavailableSQLCredentials.getDefaultSQLCredentials();
        }

        this.credentials = credentials;
    }

    @Override
    public void init() throws SQLInitialisationException {
        if (this.isClosed()) {
            HikariConfig hikariConfiguration = new HikariConfig();

            hikariConfiguration.setJdbcUrl(credentials.toURL());
            hikariConfiguration.setUsername(credentials.getUsername());
            hikariConfiguration.setPassword(credentials.getPassword());

            hikariConfiguration.setMaximumPoolSize(credentials.getPoolSize());

            try {
                this.dataSource = new HikariDataSource(hikariConfiguration);
            } catch (Throwable e) {
                throw new SQLInitialisationException(credentials, e);
            }
        }
    }

    @Override
    public void close() {
        if (!this.isClosed()) {
            this.dataSource.close();
        }
    }

    @Override
    public Connection getResource() throws SQLException {
        if (this.isClosed()) {
            this.init();
        }

        return this.dataSource.getConnection();
    }

    private boolean isClosed() {
        return this.dataSource == null || this.dataSource.isClosed();
    }
}
