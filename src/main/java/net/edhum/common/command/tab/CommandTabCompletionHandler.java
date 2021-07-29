package net.edhum.common.command.tab;

import net.edhum.common.command.CommandNode;
import net.edhum.common.command.StringBuffer;
import net.edhum.common.command.sender.CommandSender;

import java.util.List;

public interface CommandTabCompletionHandler {

    List<String> handleTabCompletion(CommandNode node, CommandSender sender, StringBuffer buffer);
}
