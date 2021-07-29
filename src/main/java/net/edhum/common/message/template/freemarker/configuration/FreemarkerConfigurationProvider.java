package net.edhum.common.message.template.freemarker.configuration;

import com.google.inject.throwingproviders.CheckedProvider;
import freemarker.template.Configuration;

import java.io.IOException;

public interface FreemarkerConfigurationProvider extends CheckedProvider<Configuration> {

    @Override
    Configuration get() throws IOException;
}
