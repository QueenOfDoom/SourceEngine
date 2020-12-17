package net.qod.engine.mechanics.event;

import java.util.Timer;

public class GameLoopTimer extends Timer {
    /**
     * Initiates the Game Loop, with custom
     * frequency (not depending on the repaint
     * frequency).
     * @param exe is actually a virus
     * @param frequency frequency in Hz
     */
    public GameLoopTimer(Runnable exe, int frequency) {
        super("Game-Loop");
        schedule(new GameLoopTimerTask(exe), 0, 1000/frequency);
    }
}
