package net.edhum.common.command.argument;

import net.edhum.common.command.argument.exception.ArgumentException;
import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.command.tab.TabCompletable;

/**
 * The implementation must define the way the argument will be parsed in {@link ArgumentParser#get(CommandSender, String)}.
 *
 * @param <T> The parsed value type of the argument
 */
// TODO: 30/07/2021 Eventually find a better name
public interface ArgumentParser<T> extends TabCompletable {

    /**
     * Returns the parsed value of the argument.
     *
     * @param sender   The command sender.
     * @param argument The string argument as given by the command sender.
     * @return The parsed value of the argument.
     */
    T get(CommandSender sender, String argument) throws ArgumentException;
}
