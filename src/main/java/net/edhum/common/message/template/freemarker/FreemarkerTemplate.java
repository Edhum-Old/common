package net.edhum.common.message.template.freemarker;

import com.google.inject.assistedinject.AssistedInject;
import freemarker.template.Configuration;
import net.edhum.common.i18n.Language;
import net.edhum.common.message.MessagePath;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.freemarker.configuration.FreemarkerConfigurationProvider;
import net.edhum.common.message.template.freemarker.configuration.UnavailableFreemarkerConfiguration;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class FreemarkerTemplate implements Template {

    private final FreemarkerTemplateLoader loader;
    private final Configuration configuration;

    @AssistedInject
    public FreemarkerTemplate(FreemarkerTemplateLoader loader, FreemarkerConfigurationProvider configurationProvider) {
        this.loader = loader;

        Configuration configuration;

        try {
            configuration = configurationProvider.get();
        } catch (IOException e) {
            e.printStackTrace();

            configuration = UnavailableFreemarkerConfiguration.getDefaultFreemarkerConfiguration();
        }

        this.configuration = configuration;
    }

    @Override
    public String render(MessagePath context, Language language) throws Exception {
        String templateFileName = this.loader.getTemplatePath(context, language);
        freemarker.template.Template template = this.configuration.getTemplate(templateFileName);

        Writer out = new StringWriter();
        template.process(context.getContext(), out);

        return out.toString();
    }
}
