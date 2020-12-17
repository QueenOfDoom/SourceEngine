package net.qod.engine.graphics.event;

import net.qod.engine.graphics.GWindow;

import java.util.TimerTask;

public class RepaintTimerTask extends TimerTask {
    GWindow window;
    public RepaintTimerTask(GWindow window) {
        this.window = window;
    }

    @Override
    public void run() {
        window.prepareScreen();
        window.repaint();
    }
}
