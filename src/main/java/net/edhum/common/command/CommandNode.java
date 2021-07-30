package net.edhum.common.command;

import java.util.List;
import java.util.Optional;

public class CommandNode {

    protected CommandNode parent;

    private final Command command;
    private final List<CommandNode> children;

    public CommandNode(Command command, List<CommandNode> children) {
        this.command = command;
        this.children = children;
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public void addNode(CommandNode node) {
        node.parent = this;

        this.children.add(node);
    }

    public Optional<CommandNode> getParent() {
        return Optional.ofNullable(this.parent);
    }

    public Command getCommand() {
        return this.command;
    }

    public List<CommandNode> getChildren() {
        return this.children;
    }
}
