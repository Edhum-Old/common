package net.edhum.common.command.sender;

import net.edhum.common.i18n.InternalisationEntity;
import net.edhum.common.permission.PermissionEntity;
import net.md_5.bungee.api.chat.BaseComponent;

public interface CommandSender extends InternalisationEntity, PermissionEntity {

    void sendMessage(String message);

    void sendMessage(BaseComponent[] components);
}
