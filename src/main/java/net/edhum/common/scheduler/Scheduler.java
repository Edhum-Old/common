package net.edhum.common.scheduler;

import java.util.concurrent.TimeUnit;

public interface Scheduler {

    void runTaskAsynchronously(Runnable runnable);

    void runTaskLater(Runnable runnable, long delay, TimeUnit timeUnit);

    void runTaskLater(Runnable runnable, long delay);

    void runRepeatingTask(Runnable runnable, long delay, long period, TimeUnit timeUnit);

    void runRepeatingTask(Runnable runnable, long period, TimeUnit timeUnit);
}
