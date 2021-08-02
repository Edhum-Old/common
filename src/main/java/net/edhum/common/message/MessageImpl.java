package net.edhum.common.message;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.i18n.Language;
import net.edhum.common.message.context.receiver.ReceiverContext;
import net.edhum.common.message.context.writer.WriterContext;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.TemplateFactory;
import net.edhum.common.plugin.annotations.PluginLogger;

import java.util.Collection;
import java.util.logging.Logger;

public class MessageImpl implements Message {

    private final Logger logger;
    private final TemplateFactory templateFactory;
    private final MessagePath context;

    @SuppressWarnings("BindingAnnotationWithoutInject")
    @AssistedInject
    public MessageImpl(@PluginLogger Logger logger, TemplateFactory templateFactory, @Assisted MessagePath context) {
        this.logger = logger;
        this.templateFactory = templateFactory;
        this.context = context;
    }

    @Override
    public void write(ReceiverContext receiverContext, WriterContext writer) {
        Collection<? extends CommandSender> receivers = receiverContext.getReceivers();

        try {
            writer.write(this.context, receivers);
        } catch (Exception e) {
            e.printStackTrace();
            this.logger.warning("This message could not be written");

            // TODO: 29/07/2021 Send a default message to the receivers 
        }
    }

    @Override
    public String get(Language language) {
        Template template = this.templateFactory.createTemplate();

        try {
            return template.render(this.context, language);
        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }
}
