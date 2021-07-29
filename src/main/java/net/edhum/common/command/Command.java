package net.edhum.common.command;

import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.execution.CommandExecutor;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.message.Message;

import java.util.Collection;
import java.util.List;

public class Command {

    private final CommandDetails details;
    private final Collection<Requirement> requirements;
    private final List<Argument> arguments;
    private final CommandExecutor executor;

    public Command(CommandDetails details,
                   Collection<Requirement> requirements,
                   List<Argument> arguments,
                   CommandExecutor executor) {
        this.details = details;
        this.requirements = requirements;
        this.arguments = arguments;
        this.executor = executor;
    }

    public String getName() {
        return this.details.getName();
    }

    public Message getDescription() {
        return this.details.getDescription();
    }

    public String getPermission() {
        return this.details.getPermission();
    }

    public List<String> getAliases() {
        return this.details.getAliases();
    }

    public Collection<Requirement> getRequirements() {
        return requirements;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
}
