package net.edhum.common.player.profile;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.group.Group;
import net.edhum.common.i18n.Language;

import java.util.Collection;
import java.util.UUID;

public class PlayerProfileImpl implements PlayerProfile {

    private final UUID uuid;
    private final String name;
    private Group group;
    private Language language;
    private long money;
    private final boolean isNewcomer;
    private final Collection<String> permissions;

    @AssistedInject
    public PlayerProfileImpl(@Assisted UUID uuid,
                      @Assisted String name,
                      @Assisted Group group,
                      @Assisted Language language,
                      @Assisted long money,
                      @Assisted boolean isNewcomer,
                      @Assisted Collection<String> permissions) {
        this.uuid = uuid;
        this.name = name;
        this.group = group;
        this.language = language;
        this.money = money;
        this.isNewcomer = isNewcomer;
        this.permissions = permissions;
    }

    @Override
    public UUID getUniqueId() {
        return this.uuid;
    }

    @Override
    public boolean isNewcomer() {
        return this.isNewcomer;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Group getGroup() {
        return this.group;
    }

    @Override
    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public Language getLanguage() {
        return this.language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public long getMoney() {
        return this.money;
    }

    @Override
    public boolean hasEnoughMoney(long amount) {
        return this.money >= amount;
    }

    @Override
    public void creditMoney(long amount) {
        this.money = Math.max(this.money + amount, 0);
    }

    @Override
    public void withdrawMoney(long amount) {
        this.money = Math.max(this.money - amount, 0);
    }

    @Override
    public Collection<String> getPermissions() {
        return this.permissions;
    }
}
