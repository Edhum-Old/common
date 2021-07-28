package net.edhum.common.shutdown;

public interface ShutdownHooks {

    void add(Runnable hook);

    void closeAll();
}
