package net.qod.engine.math.geom;

public class InsufficientPointException extends Exception {
    public InsufficientPointException(int expected, int actual) {
        super("Insufficient Points. Detected: " + actual + ". Expected: " + expected + ".");
    }
}
