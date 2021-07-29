package net.edhum.common.command.repository;

import net.edhum.common.command.CommandTree;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface CommandRepository {

    void add(CommandTree command);

    boolean contains(Predicate<CommandTree> filter);

    Optional<CommandTree> find(Predicate<CommandTree> filter);

    Set<CommandTree> findAll(Predicate<CommandTree> filter);
}
