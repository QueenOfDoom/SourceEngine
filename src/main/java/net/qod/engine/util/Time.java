package net.qod.engine.util;

import net.qod.engine.log.Logger;

public class Time {
    public static final Logger logger = new Logger(System.out);
    public static long time;
    public static boolean timerState;

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            logger.error("Could not Sleep.");
        }
    }

    public static void start() {
        time = System.nanoTime();
    }

    public static long stop() {
        return System.nanoTime()-time;
    }
}
