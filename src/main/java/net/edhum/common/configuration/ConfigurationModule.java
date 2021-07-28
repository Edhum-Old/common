package net.edhum.common.configuration;

import com.google.inject.AbstractModule;
import net.edhum.common.configuration.yaml.YAMLObjectMapper;

public class ConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ObjectMapper.class).to(YAMLObjectMapper.class);
    }
}
