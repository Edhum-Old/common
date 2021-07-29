package net.edhum.common.message.template.freemarker.configuration;

import freemarker.template.Configuration;
import freemarker.template.Version;

public class UnavailableFreemarkerConfiguration {

    private static final Version DEFAULT_FREEMARKER_VERSION = Configuration.VERSION_2_3_31;
    private static final String DEFAULT_TEMPLATE_ENCODING = "UTF-8";

    public static Configuration getDefaultFreemarkerConfiguration() {
        Configuration configuration = new Configuration(DEFAULT_FREEMARKER_VERSION);
        configuration.setDefaultEncoding(DEFAULT_TEMPLATE_ENCODING);
        // TODO: 13/07/2021 Set path
        
        return configuration;
    }
}
