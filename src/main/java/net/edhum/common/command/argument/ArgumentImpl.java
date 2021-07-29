package net.edhum.common.command.argument;

public class ArgumentImpl implements Argument {

    private final String name;
    private final boolean isRequired;
    private final ArgumentParser<?> parser;

    public ArgumentImpl(String name, boolean isRequired, ArgumentParser<?> parser) {
        this.name = name;
        this.isRequired = isRequired;
        this.parser = parser;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isRequired() {
        return isRequired;
    }

    @Override
    public ArgumentParser<?> getParser() {
        return parser;
    }
}
