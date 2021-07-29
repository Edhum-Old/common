package net.edhum.common.message.context.writer;

import net.edhum.common.message.MessagePath;
import net.edhum.common.player.Player;

import java.util.Collection;

public interface WriterContext {

    void write(MessagePath context, Collection<Player> receivers) throws Exception;
}
