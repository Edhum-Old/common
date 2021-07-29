package net.edhum.common.message;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

import java.util.Collection;
import java.util.HashSet;

public class MessageBuilder {

    private final MessageFactory messageFactory;

    private final String path;
    private final Collection<MessageArgument> arguments;

    @AssistedInject
    public MessageBuilder(MessageFactory messageFactory, @Assisted String path) {
        this.messageFactory = messageFactory;

        this.path = path;
        this.arguments = new HashSet<>();
    }

    public MessageBuilder withArgument(MessageArgument argument) {
        this.arguments.add(argument);

        return this;
    }

    public Message build() {
        MessagePath context = new MessagePath(this.path, this.arguments);

        return this.messageFactory.createMessage(context);
    }
}
