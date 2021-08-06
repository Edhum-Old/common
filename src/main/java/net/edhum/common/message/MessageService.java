package net.edhum.common.message;

import net.edhum.common.i18n.Localised;
import net.edhum.common.message.context.receiver.ReceiverContext;
import net.edhum.common.message.context.writer.WriterContext;

public interface MessageService {

    void write(Message message, ReceiverContext receiverContext, WriterContext writerContext);

    String get(Message message, Localised localised);
}
