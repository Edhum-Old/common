package net.edhum.common.persistence.sql.credentials;

import java.util.Map;

public class UnavailableSQLCredentials {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 3306;
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "";
    private static final String DEFAULT_DATABASE = "edhum";
    private static final int DEFAULT_POOL_SIZE = 8;
    private static final Map<String, String> DEFAULT_OPTIONS = Map.of("useSSL", String.valueOf(false));

    public static SQLCredentials getDefaultSQLCredentials() {
        SQLCredentials credentials = new SQLCredentials();
        credentials.setHost(DEFAULT_HOST);
        credentials.setPort(DEFAULT_PORT);
        credentials.setUsername(DEFAULT_USERNAME);
        credentials.setPassword(DEFAULT_PASSWORD);
        credentials.setDatabase(DEFAULT_DATABASE);
        credentials.setPoolSize(DEFAULT_POOL_SIZE);
        credentials.setOptions(DEFAULT_OPTIONS);

        return credentials;
    }
}
