package net.edhum.common.command.execution.exceptions;

import net.edhum.common.command.CommandNode;

public class UnknownNodeException extends Exception {

    private final CommandNode node;

    public UnknownNodeException(CommandNode node) {
        this.node = node;
    }

    public CommandNode getNode() {
        return node;
    }
}
