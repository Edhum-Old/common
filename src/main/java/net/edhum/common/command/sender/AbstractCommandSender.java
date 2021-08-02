package net.edhum.common.command.sender;

import net.edhum.common.i18n.Language;
import net.md_5.bungee.api.chat.TextComponent;

public abstract class AbstractCommandSender implements CommandSender {

    protected Language language;

    public AbstractCommandSender(Language language) {
        this.language = language;
    }

    @Override
    public void sendMessage(String message) {
        this.sendMessage(TextComponent.fromLegacyText(message));
    }

    @Override
    public Language getLanguage() {
        return this.language;
    }

    @Override
    public boolean hasPermission(String permission) {
        return permission == null || permission.isEmpty();
    }
}
