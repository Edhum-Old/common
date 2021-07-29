package net.edhum.common.command;

import java.util.ArrayList;
import java.util.List;

public class CommandNode {

    private CommandNode parent;

    private final Command command;
    private final List<CommandNode> children;

    public CommandNode(Command command) {
        this.command = command;
        this.children = new ArrayList<>();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public void addNode(CommandNode node) {
        this.children.add(node);
        node.parent = this;
    }

    public CommandNode getParent() {
        return this.parent;
    }

    public Command getCommand() {
        return this.command;
    }

    public List<CommandNode> getChildren() {
        return this.children;
    }
}
