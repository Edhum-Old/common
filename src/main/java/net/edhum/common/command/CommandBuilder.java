package net.edhum.common.command;

import com.google.inject.Inject;
import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.argument.ArgumentImpl;
import net.edhum.common.command.argument.ArgumentParser;
import net.edhum.common.command.execution.CommandExecutor;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.message.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandBuilder {

    private String name;
    private Message description;
    private String permission;
    private List<String> aliases;
    private final List<Requirement> requirements;
    private final List<Argument> arguments;
    private CommandExecutor executor;

    @Inject
    public CommandBuilder() {
        this.aliases = new ArrayList<>();
        this.requirements = new ArrayList<>();
        this.arguments = new ArrayList<>();
    }

    public CommandBuilder withName(String name) {
        this.name = name;

        return this;
    }

    public CommandBuilder withDescription(Message description) {
        this.description = description;

        return this;
    }

    public CommandBuilder withPermission(String permission) {
        this.permission = permission;

        return this;
    }

    public CommandBuilder withAlias(String alias) {
        this.aliases.add(alias);

        return this;
    }

    public CommandBuilder withAliases(String... aliases) {
        this.aliases = Arrays.asList(aliases);

        return this;
    }

    public CommandBuilder withRequirement(Requirement requirement) {
        this.requirements.add(requirement);

        return this;
    }

    public CommandBuilder withArgument(String name, ArgumentParser<?> argumentParser, boolean isRequired) {
        Argument argument = new ArgumentImpl(name, isRequired, argumentParser);

        this.arguments.add(argument);

        return this;
    }

    public CommandBuilder withExecutor(CommandExecutor executor) {
        this.executor = executor;

        return this;
    }

    public Command build() {
        CommandDetails details = new CommandDetails(
                this.name,
                this.description,
                this.permission,
                this.aliases
        );

        return new Command(
                details,
                this.requirements,
                this.arguments,
                this.executor);
    }
}
