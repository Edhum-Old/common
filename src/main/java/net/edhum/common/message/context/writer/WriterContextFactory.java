package net.edhum.common.message.context.writer;

import javax.inject.Named;

public interface WriterContextFactory {

    @Named("chat") WriterContext chat();

    @Named("string") WriterContext string();
}
