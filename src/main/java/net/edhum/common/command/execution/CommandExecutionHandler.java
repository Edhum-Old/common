package net.edhum.common.command.execution;

import net.edhum.common.command.CommandNode;
import net.edhum.common.command.CommandLineBuffer;
import net.edhum.common.command.argument.exception.ArgumentException;
import net.edhum.common.command.execution.exceptions.UnknownNodeException;
import net.edhum.common.command.execution.exceptions.InvalidRequirementException;
import net.edhum.common.command.execution.exceptions.InvalidPermissionException;
import net.edhum.common.command.execution.exceptions.InvalidSyntaxException;
import net.edhum.common.command.sender.CommandSender;

public interface CommandExecutionHandler {

    void handleExecution(CommandNode node, CommandSender sender, CommandLineBuffer buffer) throws ArgumentException, UnknownNodeException, InvalidPermissionException, InvalidRequirementException, InvalidSyntaxException;
}
