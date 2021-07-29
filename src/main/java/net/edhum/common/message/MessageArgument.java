package net.edhum.common.message;

public class MessageArgument {

    private final String name;
    private final Object value;

    public MessageArgument(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
