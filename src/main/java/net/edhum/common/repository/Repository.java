package net.edhum.common.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface Repository<T> {

    boolean contains(Predicate<T> predicate);

    Optional<T> find(Predicate<T> predicate);

    Collection<T> findAll(Predicate<T> predicate);
}
