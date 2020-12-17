package net.qod.engine.graphics.event;

import net.qod.engine.graphics.GWindow;

import java.util.Timer;

public class RepaintTimer extends Timer {
    public RepaintTimer(GWindow window, int frames) {
        super("Repaint-Timer");
        schedule(new RepaintTimerTask(window), 0, 1000/frames);
    }
}
