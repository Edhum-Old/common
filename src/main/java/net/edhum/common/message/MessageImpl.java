package net.edhum.common.message;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageImpl implements Message {

    private final String path;
    private final Map<String, Object> context;

    public MessageImpl(String path, Collection<MessageArgument> arguments) {
        this.path = path;

        this.context = arguments.stream()
                .collect(Collectors.toMap(MessageArgument::getName, MessageArgument::getValue));
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getContext() {
        return context;
    }
}
