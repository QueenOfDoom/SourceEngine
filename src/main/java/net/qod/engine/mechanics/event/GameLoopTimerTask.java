package net.qod.engine.mechanics.event;

import java.util.TimerTask;

public class GameLoopTimerTask extends TimerTask {
    Runnable exe;
    public GameLoopTimerTask(Runnable exe) {
        this.exe = exe;
    }

    @Override
    public void run() {
        exe.run();
    }
}
