package net.edhum.common.console;

import net.edhum.common.command.sender.AbstractCommandSender;
import net.edhum.common.i18n.language.Language;

public abstract class AbstractConsole extends AbstractCommandSender implements Console {

    public AbstractConsole(Language language) {
        super(language);
    }

    @Override
    public boolean hasPermission(String permission) {
        return true;
    }
}
