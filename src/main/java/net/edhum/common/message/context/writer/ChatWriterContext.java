package net.edhum.common.message.context.writer;

import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.message.Message;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.TemplateFactory;

import java.util.Collection;

public class ChatWriterContext implements WriterContext {

    private final TemplateFactory templateFactory;

    @AssistedInject
    public ChatWriterContext(TemplateFactory templateFactory) {
        this.templateFactory = templateFactory;
    }

    @Override
    public void write(Message message, Collection<? extends CommandSender> receivers) throws Exception {
        Template template = this.templateFactory.createTemplate();

        for (CommandSender receiver : receivers) {
            String out = template.render(message, receiver.getLanguage());
            receiver.sendMessage(out);
        }
    }
}
