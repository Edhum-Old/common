package net.edhum.common.message.context.writer;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.message.MessagePath;
import net.edhum.common.message.template.Template;
import net.edhum.common.message.template.TemplateFactory;
import net.edhum.common.utils.StringBuffer;

import java.util.Collection;
import java.util.StringJoiner;

public class StringWriterContext implements WriterContext {

    private final TemplateFactory templateFactory;
    private final StringBuffer buffer;

    @AssistedInject
    public StringWriterContext(TemplateFactory templateFactory, @Assisted StringBuffer buffer) {
        this.templateFactory = templateFactory;
        this.buffer = buffer;
    }

    @Override
    public void write(MessagePath context, Collection<? extends CommandSender> receivers) throws Exception {
        this.buffer.clear();

        StringJoiner joiner = new StringJoiner(",");

        Template template = this.templateFactory.createTemplate();

        for (CommandSender receiver : receivers) {
            joiner.add(template.render(context, receiver.getLanguage()));
        }

        this.buffer.setValue(joiner.toString());
    }
}
