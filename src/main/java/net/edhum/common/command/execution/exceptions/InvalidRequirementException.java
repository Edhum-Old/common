package net.edhum.common.command.execution.exceptions;

import net.edhum.common.message.Message;

public class InvalidRequirementException extends Exception {

    private final Message error;

    public InvalidRequirementException(Message error) {
        this.error = error;
    }

    public Message getError() {
        return error;
    }
}
