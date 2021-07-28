package net.edhum.common.configuration;

import java.io.InputStream;

public interface ObjectMapper {

    <T> T load(Class<T> type, InputStream in);
}
