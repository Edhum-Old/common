package net.edhum.common.command.dispatcher;

import com.google.inject.Inject;
import net.edhum.common.command.CommandTree;
import net.edhum.common.command.StringBuffer;
import net.edhum.common.command.argument.exception.ArgumentException;
import net.edhum.common.command.execution.CommandExecutionHandler;
import net.edhum.common.command.execution.exceptions.InvalidRequirementException;
import net.edhum.common.command.execution.exceptions.InvalidPermissionException;
import net.edhum.common.command.execution.exceptions.InvalidSyntaxException;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.command.tab.CommandTabCompletionHandler;

import java.util.List;

public class CommandDispatcherImpl implements CommandDispatcher {

    private final CommandExecutionHandler commandExecutionHandler;
    private final CommandTabCompletionHandler commandTabCompletionHandler;

    @Inject
    public CommandDispatcherImpl(CommandExecutionHandler commandExecutionHandler, CommandTabCompletionHandler commandTabCompletionHandler) {
        this.commandExecutionHandler = commandExecutionHandler;
        this.commandTabCompletionHandler = commandTabCompletionHandler;
    }

    @Override
    public void dispatchExecution(CommandTree tree, CommandSender sender, String[] args) throws ArgumentException, InvalidRequirementException, InvalidPermissionException, InvalidSyntaxException {
        StringBuffer buffer = this.createBuffer(args);

        this.commandExecutionHandler.handleExecution(tree.getRoot(), sender, buffer);
    }

    @Override
    public List<String> dispatchTabCompletion(CommandTree tree, CommandSender sender, String[] args) {
        StringBuffer buffer = this.createBuffer(args);

        return this.commandTabCompletionHandler.handleTabCompletion(tree.getRoot(), sender, buffer);
    }

    private StringBuffer createBuffer(String[] args) {
        return new StringBuffer(args);
    }
}
