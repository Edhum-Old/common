package net.edhum.common.player;

import net.edhum.common.command.sender.CommandSender;
import net.edhum.common.player.profile.PlayerProfile;

public interface Player extends CommandSender {

    PlayerProfile getProfile();
}
