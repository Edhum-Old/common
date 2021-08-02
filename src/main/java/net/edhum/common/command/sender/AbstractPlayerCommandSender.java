package net.edhum.common.command.sender;

import net.edhum.common.i18n.Language;

import java.util.Collection;

public abstract class AbstractPlayerCommandSender extends AbstractCommandSender implements CommandSender {

    protected final Collection<String> permissions;

    public AbstractPlayerCommandSender(Language language, Collection<String> permissions) {
        super(language);

        this.permissions = permissions;
    }

    @Override
    public boolean hasPermission(String permission) {
        return super.hasPermission(permission) || this.permissions.contains(permission);
    }
}
