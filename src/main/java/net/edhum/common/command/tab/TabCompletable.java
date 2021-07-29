package net.edhum.common.command.tab;

import net.edhum.common.command.sender.CommandSender;

import java.util.Collection;
import java.util.Collections;

/**
 * This interface can be implemented by an {@code ArgumentParser} that can be tab completable.
 * <p>
 * The implementation must define the collection of the authorized values for the argument
 * in {@link TabCompletable#tabComplete(CommandSender)}.
 */
public interface TabCompletable {

    /**
     * Returns the authorized values for the argument.
     *
     * @param sender The command sender.
     * @return A collection of the authorized values for the argument.
     */
    default Collection<String> tabComplete(CommandSender sender) {
        return Collections.emptyList();
    }
}
