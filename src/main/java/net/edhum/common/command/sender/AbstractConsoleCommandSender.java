package net.edhum.common.command.sender;

import net.edhum.common.i18n.Language;

public abstract class AbstractConsoleCommandSender extends AbstractCommandSender {

    public AbstractConsoleCommandSender(Language language) {
        super(language);
    }

    @Override
    public boolean hasPermission(String permission) {
        return true;
    }
}
