package net.edhum.common.command.execution.exceptions;

import net.edhum.common.command.CommandNode;

public class InvalidNodeException extends Exception {

    private final CommandNode node;

    public InvalidNodeException(CommandNode node) {
        this.node = node;
    }

    public CommandNode getNode() {
        return node;
    }
}
