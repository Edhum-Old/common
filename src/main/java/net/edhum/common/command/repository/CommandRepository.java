package net.edhum.common.command.repository;

import net.edhum.common.command.CommandTree;
import net.edhum.common.repository.Repository;

public interface CommandRepository extends Repository<CommandTree> {

    void add(CommandTree command);
}
