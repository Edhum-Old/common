package net.edhum.common.command;

import java.util.*;

public class CommandNode {

    protected CommandNode parent;

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
        node.parent = this;

        this.children.add(node);
    }

    public Optional<CommandNode> getParent() {
        return Optional.ofNullable(this.parent);
    }

    public Deque<CommandNode> getPath() {
        Deque<CommandNode> path = new ArrayDeque<>();
        path.addFirst(this);

        Optional<CommandNode> optionalParent = this.getParent();
        while (optionalParent.isPresent()) {
            CommandNode parent = optionalParent.get();
            path.addFirst(parent);

            optionalParent = parent.getParent();
        }

        return path;
    }

    public Command getCommand() {
        return this.command;
    }

    public List<CommandNode> getChildren() {
        return this.children;
    }
}
