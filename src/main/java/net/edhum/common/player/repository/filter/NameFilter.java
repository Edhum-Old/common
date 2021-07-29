package net.edhum.common.player.repository.filter;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import net.edhum.common.player.Player;

import java.util.function.Predicate;

public class NameFilter implements Predicate<Player> {

    private final String name;

    @AssistedInject
    public NameFilter(@Assisted String name) {
        this.name = name;
    }

    @Override
    public boolean test(Player player) {
        return player.getName().equalsIgnoreCase(this.name);
    }
}
