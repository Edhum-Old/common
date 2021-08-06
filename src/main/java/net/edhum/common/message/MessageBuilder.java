package net.edhum.common.message;

import java.util.Collection;
import java.util.HashSet;

public class MessageBuilder {

    private String path;
    private final Collection<MessageArgument> arguments;

    public MessageBuilder() {
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
        return new MessageImpl(this.path, this.arguments);
    }
}
