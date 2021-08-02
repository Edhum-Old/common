package net.edhum.common.command.repository;

import net.edhum.common.command.CommandTree;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface CommandRepository {

    void add(CommandTree command);

    boolean contains(Predicate<CommandTree> predicate);

    Optional<CommandTree> find(Predicate<CommandTree> predicate);

    Collection<CommandTree> findAll(Predicate<CommandTree> predicate);
}
