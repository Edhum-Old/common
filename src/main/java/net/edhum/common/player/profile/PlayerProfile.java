package net.edhum.common.player.profile;

import net.edhum.common.group.Group;
import net.edhum.common.i18n.Language;

import java.util.Collection;
import java.util.UUID;

public interface PlayerProfile {

    UUID getUniqueId();

    boolean isNewcomer();

    String getName();

    Group getGroup();

    void setGroup(Group group);

    Language getLanguage();

    void setLanguage(Language language);

    long getMoney();

    boolean hasEnoughMoney(long amount);

    void creditMoney(long amount);

    void withdrawMoney(long amount);

    Collection<String> getPermissions();
}
