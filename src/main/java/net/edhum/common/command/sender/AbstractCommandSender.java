package net.edhum.common.command.sender;

import net.edhum.common.i18n.language.Language;
import net.kyori.adventure.text.Component;

public abstract class AbstractCommandSender implements CommandSender {

    protected Language language;

    public AbstractCommandSender(Language language) {
        this.language = language;
    }

    @Override
    public void sendMessage(String message) {
        this.sendMessage(Component.text(message));
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
