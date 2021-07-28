package net.edhum.common.listener;

public interface ListenerRegisterer<T> {

    void registerListener(T listener);
}
