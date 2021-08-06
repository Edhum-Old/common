package net.edhum.common.message;

import com.google.inject.Inject;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.i18n.Language;
import net.edhum.common.i18n.Localised;
import net.edhum.common.message.context.receiver.ReceiverContext;
import net.edhum.common.message.context.writer.WriterContext;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.TemplateFactory;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.util.Collection;
import java.util.logging.Logger;

public class MessageServiceImpl implements MessageService {

    private final Logger logger;
    private final TemplateFactory templateFactory;

    @Inject
    public MessageServiceImpl(@PluginLogger Logger logger, TemplateFactory templateFactory) {
        this.logger = logger;
        this.templateFactory = templateFactory;
    }

    @Override
    public void write(Message message, ReceiverContext receiver, WriterContext writer) {
        Collection<? extends CommandSender> receivers = receiver.getReceivers();

        try {
            writer.write(message, receivers);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.warning("This message could not be read");

            // TODO: 29/07/2021 Send a default message to the receivers
        }
    }

    @Override
    public String get(Message message, Localised localised) {
        return this.get(message, localised.getLanguage());
    }

    @Override
    public String get(Message message, Language language) {
        Template template = this.templateFactory.createTemplate();

        try {
            return template.render(message, language).trim();
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.warning("This message could not be read");

            return ""; // TODO: 06/08/2021 Returns a default message
        }
    }
}
