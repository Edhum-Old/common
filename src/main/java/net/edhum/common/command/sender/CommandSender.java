package net.edhum.common.command.sender;

import net.edhum.common.i18n.Localised;
import net.edhum.common.permission.PermissionEntity;
import net.kyori.adventure.text.Component;

public interface CommandSender extends Localised, PermissionEntity {

    void sendMessage(String message);

    void sendMessage(Component component);
}
