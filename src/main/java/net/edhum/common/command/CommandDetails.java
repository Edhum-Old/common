package net.edhum.common.command;

import net.edhum.common.message.Message;

import java.util.List;

public class CommandDetails {

    private final String name;
    private final Message description;
    private final String permission;
    private final List<String> aliases;

    public CommandDetails(String name, Message description, String permission, List<String> aliases) {
        this.name = name;
        this.description = description;
        this.permission = permission;
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public Message getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }
}
