package net.edhum.common.command.argument.exception;

import net.edhum.common.message.Message;

public class ArgumentException extends Exception {

    private final Message error;

    public ArgumentException(Message error) {
        this.error = error;
    }

    public Message getError() {
        return error;
    }
}
