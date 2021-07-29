package net.edhum.common.message.context.writer;

import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.message.MessagePath;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.TemplateFactory;
import net.edhum.common.player.Player;

import java.util.Collection;

public class ChatWriterContext implements WriterContext {

    private final TemplateFactory templateFactory;

    @AssistedInject
    public ChatWriterContext(TemplateFactory templateFactory) {
        this.templateFactory = templateFactory;
    }

    @Override
    public void write(MessagePath context, Collection<Player> receivers) throws Exception {
        Template template = this.templateFactory.createTemplate();

        for (Player receiver : receivers) {
            String out = template.render(context, receiver.getLanguage());
            receiver.sendMessage(out);
        }
    }
}
