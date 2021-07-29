package net.edhum.common.command.argument.exception;

public class ArgumentException extends Exception {

    private final String error;

    public ArgumentException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
