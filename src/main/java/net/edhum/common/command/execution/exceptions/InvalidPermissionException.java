package net.edhum.common.command.execution.exceptions;

public class InvalidPermissionException extends Exception {

    private final String permission;

    public InvalidPermissionException(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
