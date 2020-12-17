package net.qod.engine.math.vector;

import net.qod.engine.math.geom.GPoint2D;

public class Vector2D {
    double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(GPoint2D origin, GPoint2D destination) {
        this.x = destination.getX() - origin.getX();
        this.y = destination.getY() - origin.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double norm() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }

    public double getAngle() {
        return Math.toDegrees(Math.asin(y/x));
    }

    public Vector2D multiply(IMatrix<Float> matrix) {
        double nx = 0, ny = 0;
        try {
            nx = x*matrix.get(0, 0).doubleValue() + y*matrix.get(1, 0).doubleValue();
            ny = x*matrix.get(0, 1).doubleValue() + y*matrix.get(1, 1).doubleValue();
        } catch(IllegalShapeException e) {
            System.err.println("Matrix Size does not correspond to Vector Size!");
        }
        return new Vector2D(nx, ny);
    }

    public Vector2D unit() {
        return new Vector2D(x / norm(), y / norm());
    }

    public Vector2D add(Vector2D summand) {
        return new Vector2D(x + summand.getX(), y + summand.getY());
    }

    public Vector2D sub(Vector2D subtrahend) {
        return new Vector2D(x - subtrahend.getX(), y - subtrahend.getY());
    }

    public Vector2D negate() {
        return new Vector2D(-x, -y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }

    public Vector2D scale(double factor) {
        return new Vector2D(x*factor, y*factor);
    }
}
