package net.edhum.common.command.argument;

import net.edhum.common.command.execution.CommandExecutor;
import net.edhum.common.command.execution.buffer.ArgumentBuffer;

/**
 * The {@code Argument} interface represents an argument in a minecraft command, as bellows :
 * <p>
 * <code>/coins add &lt;amount&gt; [player]</code>, where :
 * <ul>
 *     <li><code>amount</code> is a required {@code Argument}</li>
 *     <li><code>player</code> is a facultative {@code Argument}</li>
 * </ul>
 * <p>
 * An {@code Argument} can be required or facultative. All {@code Arguments} that follow a facultative argument must be
 * facultative too.
 * <p>
 * Once parsed, {@code Arguments} are stored in an {@link ArgumentBuffer} and can
 * be retrieved in the {@link CommandExecutor}.
 */
public interface Argument {

    /**
     * Returns the argument name, as it will appear in the minecraft generated documentation of the command.
     *
     * @return The name of the argument.
     */
    String getName();

    /**
     * Checks if the argument is required.
     *
     * @return {@code true} if it the argument is required, {@code false} otherwise.
     */
    boolean isRequired();


    ArgumentParser<?> getParser();
}
