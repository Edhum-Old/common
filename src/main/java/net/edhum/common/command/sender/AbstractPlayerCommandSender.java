package net.edhum.common.command.sender;

import net.edhum.common.i18n.Language;

public abstract class AbstractPlayerCommandSender extends AbstractCommandSender implements CommandSender {

    public AbstractPlayerCommandSender(Language language) {
        super(language);
    }

    @Override
    public boolean hasPermission(String permission) {
        return permission == null || permission.isEmpty();
    }
}
