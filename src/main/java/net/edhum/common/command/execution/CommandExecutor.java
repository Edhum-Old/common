package net.edhum.common.command.execution;

import net.edhum.common.command.execution.buffer.ArgumentBuffer;
import net.edhum.common.command.execution.context.CommandContext;
import net.edhum.common.command.execution.result.CommandResult;

/**
 * This interface can be implemented to define the behavior of a command after its execution.
 * <p>
 * No condition other than those already existing should be defined.
 */
public interface CommandExecutor {

    CommandResult execute(CommandContext context, ArgumentBuffer buffer);
}
