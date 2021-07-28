package net.edhum.common.persistence.sql.credentials;

import com.google.inject.throwingproviders.CheckedProvider;

import java.io.IOException;

public interface SQLCredentialsProvider extends CheckedProvider<SQLCredentials> {

    @Override
    SQLCredentials get() throws IOException;
}
