package net.qod.engine.math.vector;

public class IllegalShapeException extends Exception {
    public IllegalShapeException(int expected, int actual) {
        super("Shape Mismatch. Detected: " + actual + ". Expected: " + expected + ".");
    }
}
