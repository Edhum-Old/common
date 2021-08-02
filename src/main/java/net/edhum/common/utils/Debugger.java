package net.edhum.common.utils;

import com.google.inject.Inject;

import java.util.logging.Logger;

public class Debugger {

    private final Logger logger;
    private long timer;

    @Inject
    public Debugger(Logger logger) {
        this.logger = logger;
    }

    public void start() {
        this.timer = System.currentTimeMillis();
    }

    public void end() {
        long difference = System.currentTimeMillis() - this.timer;
        this.logger.info(String.format("Debugger : Took %dms", difference));
    }
}
