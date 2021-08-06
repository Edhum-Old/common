package net.edhum.common.command;

import net.edhum.common.command.argument.Argument;
import net.edhum.common.command.execution.CommandExecutor;
import net.edhum.common.command.requirement.Requirement;
import net.edhum.common.message.Message;

import java.util.Collection;
import java.util.List;

public interface Command {

    String getName();

    Message getDescription();

    String getPermission();

    List<String> getAliases();

    Collection<Requirement> getRequirements();

    List<Argument> getArguments();

    CommandExecutor getExecutor();
}
