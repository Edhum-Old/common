package net.edhum.common.player;

import net.edhum.common.command.sender.AbstractCommandSender;
import net.edhum.common.player.profile.PlayerProfile;

public abstract class AbstractPlayer extends AbstractCommandSender implements Player {

    protected final PlayerProfile profile;

    public AbstractPlayer(PlayerProfile profile) {
        super(profile.getLanguage());

        this.profile = profile;
    }

    @Override
    public PlayerProfile getProfile() {
        return this.profile;
    }
}
