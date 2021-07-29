package net.edhum.common.command;

public class CommandTree {

    private final CommandNode root;

    public CommandTree(CommandNode root) {
        this.root = root;
    }

    public CommandNode getRoot() {
        return root;
    }
}
