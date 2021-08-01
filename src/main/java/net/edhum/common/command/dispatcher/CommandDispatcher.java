package net.edhum.common.command.dispatcher;

import net.edhum.common.command.CommandTree;
import net.edhum.common.command.argument.exception.ArgumentException;
import net.edhum.common.command.execution.exceptions.InvalidNodeException;
import net.edhum.common.command.execution.exceptions.InvalidRequirementException;
import net.edhum.common.command.execution.exceptions.InvalidPermissionException;
import net.edhum.common.command.execution.exceptions.InvalidSyntaxException;
import net.edhum.common.command.sender.CommandSender;

import java.util.List;

public interface CommandDispatcher {

    void dispatchExecution(CommandTree tree, CommandSender sender, String[] args) throws ArgumentException, InvalidNodeException, InvalidPermissionException, InvalidRequirementException, InvalidSyntaxException;

    List<String> dispatchTabCompletion(CommandTree tree, CommandSender sender, String[] args);
}
