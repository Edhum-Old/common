package net.edhum.common.message.template.freemarker;

import com.google.inject.Inject;
import net.edhum.common.i18n.Language;
import net.edhum.common.message.MessagePath;
import net.edhum.common.message.template.TemplateFolder;

import java.nio.file.Path;

public class FreemarkerTemplateLoader {

    private static final String FREEMARKER_TEMPLATE_FILE_EXTENSION = "flth";

    private final Path templateFolder;

    @Inject
    public FreemarkerTemplateLoader(@TemplateFolder Path templateFolder) {
        this.templateFolder = templateFolder;
    }

    public String getTemplatePath(MessagePath context, Language language) {
        String templateFileName = String.format("%s.%s", context.getPath(), FREEMARKER_TEMPLATE_FILE_EXTENSION);
        Path templateFolderPath = this.templateFolder.resolve(language.getTag());

        Path templatePath = templateFolderPath.resolve(templateFileName);

        return this.templateFolder.relativize(templatePath).toString();
    }
}
