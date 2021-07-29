package net.edhum.common.command.execution.exceptions;

import net.edhum.common.command.CommandNode;

public class InvalidSyntaxException extends Exception {

    private final CommandNode node;

    public InvalidSyntaxException(CommandNode node) {
        this.node = node;
    }

    public CommandNode getNode() {
        return node;
    }
}
