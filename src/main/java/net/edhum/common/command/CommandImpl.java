package net.edhum.common.command;

import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.execution.CommandExecutor;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.message.Message;

import java.util.Collection;
import java.util.List;

public class CommandImpl implements Command {

    private final CommandDetails details;
    private final Collection<Requirement> requirements;
    private final List<Argument> arguments;
    private final CommandExecutor executor;

    public CommandImpl(CommandDetails details,
                       Collection<Requirement> requirements,
                       List<Argument> arguments,
                       CommandExecutor executor) {
        this.details = details;
        this.requirements = requirements;
        this.arguments = arguments;
        this.executor = executor;
    }

    @Override
    public String getName() {
        return this.details.getName();
    }

    @Override
    public Message getDescription() {
        return this.details.getDescription();
    }

    @Override
    public String getPermission() {
        return this.details.getPermission();
    }

    @Override
    public List<String> getAliases() {
        return this.details.getAliases();
    }

    @Override
    public Collection<Requirement> getRequirements() {
        return requirements;
    }

    @Override
    public List<Argument> getArguments() {
        return arguments;
    }

    @Override
    public CommandExecutor getExecutor() {
        return executor;
    }
}
