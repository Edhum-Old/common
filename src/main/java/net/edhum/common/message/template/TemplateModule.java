package net.edhum.common.message.template;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.throwingproviders.CheckedProvides;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import freemarker.template.Configuration;
import freemarker.template.Version;
import net.edhum.common.message.template.freemarker.FreemarkerTemplate;
import net.edhum.common.message.template.freemarker.configuration.FreemarkerConfigurationProvider;
import net.edhum.common.plugin.annotations.PluginDataFolder;

import java.io.IOException;
import java.nio.file.Path;

// TODO: 29/07/2021 Put templates in a cache if possible
public class TemplateModule extends AbstractModule {

    private static final String TEMPLATE_FOLDER = "templates";

    private static final Version FREEMARKER_VERSION = Configuration.VERSION_2_3_31;
    private static final String TEMPLATE_ENCODING = "UTF-8";

    @Override
    protected void configure() {
        install(ThrowingProviderBinder.forModule(this));

        install(new FactoryModuleBuilder()
                .implement(Template.class, FreemarkerTemplate.class)
                .build(TemplateFactory.class));
    }

    @Provides
    @TemplateFolder
    public Path provideTemplateFolder(@PluginDataFolder Path dataFolder) {
        return dataFolder.resolve(TEMPLATE_FOLDER);
    }

    @SuppressWarnings("BindingAnnotationWithoutInject")
    @CheckedProvides(FreemarkerConfigurationProvider.class)
    public Configuration provideConfiguration(@TemplateFolder Path templateFolder) throws IOException {
        Configuration configuration = new Configuration(FREEMARKER_VERSION);

        configuration.setDefaultEncoding(TEMPLATE_ENCODING);
        configuration.setDirectoryForTemplateLoading(templateFolder.toFile());

        return configuration;
    }
}
