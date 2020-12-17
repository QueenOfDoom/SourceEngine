package net.qod.engine.math.geom;

import net.qod.engine.math.vector.Vector2D;

public class GPoint2D {
    double x, y;

    public GPoint2D(Vector2D vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public GPoint2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public GPoint2D(GPoint2D origin, Vector2D vector) {
        this.x = origin.getX() + vector.getX();
        this.y = origin.getY() + vector.getY();
    }

    public Vector2D toVector2D() {
        return new Vector2D(x, y);
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
