package net.edhum.common.message;

import net.edhum.common.i18n.Language;
import net.edhum.common.message.context.receiver.ReceiverContext;
import net.edhum.common.message.context.writer.WriterContext;

public interface Message {

    void write(ReceiverContext receiverContext, WriterContext writerContext);

    String get(Language language);
}