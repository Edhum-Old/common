package net.edhum.common.player;

import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.group.Group;
import net.edhum.common.i18n.Language;

import java.util.UUID;

public interface Player extends CommandSender {

    UUID getUniqueId();

    boolean isNewcomer();

    String getName();

    Group getGroup();

    long getMoney();

    boolean hasEnoughMoney(long amount);

    void creditMoney(long amount);

    void withdrawMoney(long amount);

    void setLanguage(Language language);
}
