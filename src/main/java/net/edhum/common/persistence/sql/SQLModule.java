package net.edhum.common.persistence.sql;

import com.google.inject.AbstractModule;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import net.edhum.common.configuration.ObjectMapper;
import net.edhum.common.persistence.sql.credentials.SQLCredentials;
import net.edhum.common.persistence.sql.credentials.SQLCredentialsProvider;
import net.edhum.common.plugin.annotations.PluginDataFolder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SQLModule extends AbstractModule {

    private static final String SQL_CONFIGURATION_FILE_NAME = "sql.yml";

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));

        bind(SQLAccess.class).to(SQLPoolAccess.class).asEagerSingleton();
    }

    @SuppressWarnings("BindingAnnotationWithoutInject")
    @CheckedProvides(SQLCredentialsProvider.class)
    public SQLCredentials provideSQLCredentials(@PluginDataFolder Path dataFolder, ObjectMapper mapper) throws IOException {
        try (InputStream in = Files.newInputStream(dataFolder.resolve(SQL_CONFIGURATION_FILE_NAME))) {
            return mapper.load(SQLCredentials.class, in);
        }
    }
}
