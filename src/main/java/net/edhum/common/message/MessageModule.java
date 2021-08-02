package net.edhum.common.message;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;
import net.edhum.common.message.context.receiver.*;
import net.edhum.common.message.context.writer.ChatWriterContext;
import net.edhum.common.message.context.writer.StringWriterContext;
import net.edhum.common.message.context.writer.WriterContext;
import net.edhum.common.message.context.writer.WriterContextFactory;
import net.edhum.common.message.template.TemplateModule;

public class MessageModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new TemplateModule());

        install(new FactoryModuleBuilder()
                .implement(ReceiverContext.class, Names.named("single"), SingleReceiverContext.class)
                .build(ReceiverContextFactory.class));

        install(new FactoryModuleBuilder()
                .implement(WriterContext.class, Names.named("chat"), ChatWriterContext.class)
                .implement(WriterContext.class, Names.named("string"), StringWriterContext.class)
                .build(WriterContextFactory.class));

        install(new FactoryModuleBuilder()
                .implement(Message.class, MessageImpl.class)
                .build(MessageFactory.class));

        install(new FactoryModuleBuilder()
                .implement(MessageBuilder.class, MessageBuilder.class)
                .build(MessageBuilderFactory.class));
    }
}
