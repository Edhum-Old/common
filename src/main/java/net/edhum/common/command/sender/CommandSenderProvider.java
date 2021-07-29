package net.edhum.common.command.sender;

import net.edhum.common.command.sender.exceptions.UnsupportedSenderException;

public interface CommandSenderProvider<T> {

    CommandSender get(T sender) throws UnsupportedSenderException;
}
