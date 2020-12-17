package net.qod.engine.log;

import java.io.PrintStream;
import java.time.LocalTime;

public class Logger {
    public static final int DEBUG = 0x0;
    public static final int INFO = 0x1;
    public static final int WARN = 0x2;
    public static final int ERROR = 0x3;
    public static final int FATAL = 0x4;

    int level = 0;
    PrintStream[] out;

    public Logger(PrintStream... output) {
        this.out = output;
    }

    public String format(String mode, String message) {
        LocalTime time = LocalTime.now();
        String thread = Thread.currentThread().getName();
        return String.format("[%s] [%s] (%s) %s\n",
                mode, time.toString().substring(0, 12), thread, message);
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void debug(String message) {
        if(level > DEBUG) return;
        for(PrintStream output:out) {
            output.print("\u001b[0m" + format("DEBUG", message));
        }
    }

    public void info(String message) {
        if(level > INFO) return;
        for(PrintStream output:out) {
            output.print("\u001b[34m" + format("INFO", message));
        }
    }

    public void warn(String message) {
        if(level > WARN) return;
        for(PrintStream output:out) {
            output.print("\u001b[33m" + format("WARN", message));
        }
    }

    public void error(String message) {
        if(level > ERROR) return;
        for(PrintStream output:out) {
            output.print("\u001b[31m" + format("ERROR", message));
        }
    }

    public void fatal(String message) {
        for(PrintStream output:out) {
            output.print("\u001b[31m" + format("FATAL", message));
        }
    }
}
