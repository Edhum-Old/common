package net.edhum.common.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractRepository<T> implements Repository<T> {

    protected abstract Collection<T> getValues();

    @Override
    public boolean contains(Predicate<T> predicate) {
        return this.find(predicate).isPresent();
    }

    @Override
    public Optional<T> find(Predicate<T> predicate) {
        return this.getValues().stream()
                .filter(predicate)
                .findAny();
    }

    @Override
    public Collection<T> findAll(Predicate<T> predicate) {
        return this.getValues().stream()
                .filter(predicate)
                .collect(Collectors.toSet());
    }
}
