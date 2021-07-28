package net.edhum.common.persistence;

import com.google.inject.AbstractModule;
import net.edhum.common.persistence.sql.SQLModule;

public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new SQLModule());
    }
}
