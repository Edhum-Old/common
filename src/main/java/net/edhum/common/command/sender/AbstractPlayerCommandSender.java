package net.edhum.common.command.sender;

import net.edhum.common.i18n.Language;

import java.util.Collection;

public abstract class AbstractPlayerCommandSender extends AbstractCommandSender implements CommandSender {

    protected Collection<String> permissions;

    public AbstractPlayerCommandSender(Language language) {
        super(language);
    }

    @Override
    public boolean hasPermission(String permission) {
        return super.hasPermission(permission) || this.permissions != null && this.permissions.contains(permission);
    }
}
