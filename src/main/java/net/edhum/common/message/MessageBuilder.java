package net.edhum.common.message;

import com.google.inject.assistedinject.AssistedInject;

import java.util.Collection;
import java.util.HashSet;

public class MessageBuilder {

    private final MessageFactory messageFactory;

    private String path;
    private final Collection<MessageArgument> arguments;

    @AssistedInject
    public MessageBuilder(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
        this.arguments = new HashSet<>();
    }

    public MessageBuilder withPath(String path) {
        this.path = path;

        return this;
    }

    public MessageBuilder withArgument(MessageArgument argument) {
        this.arguments.add(argument);

        return this;
    }

    public MessageBuilder withArgument(String name, Object value) {
        return this.withArgument(new MessageArgument(name, value));
    }

    public Message build() {
        MessagePath context = new MessagePath(this.path, this.arguments);

        return this.messageFactory.createMessage(context);
    }
}
