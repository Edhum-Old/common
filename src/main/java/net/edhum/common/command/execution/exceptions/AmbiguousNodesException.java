package net.edhum.common.command.execution.exceptions;

import net.edhum.common.command.CommandNode;

import java.util.List;

public class AmbiguousNodesException extends RuntimeException {

    private final List<CommandNode> nodes;

    public AmbiguousNodesException(List<CommandNode> nodes) {
        this.nodes = nodes;
    }

    public List<CommandNode> getNodes() {
        return nodes;
    }
}
