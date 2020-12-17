package net.qod.engine.math.geom;

import net.qod.engine.math.vector.IMatrix;
import net.qod.engine.math.vector.Matrix2f;
import net.qod.engine.math.vector.Vector2D;

public class GRectangle extends GPolygon {
    public GRectangle(GPoint2D[] points) {
        super(points);
    }

    public GRectangle(double[] x, double[] y) throws InsufficientPointException {
        super(x, y, 4);
    }

    public double getWidth() {
        return new Vector2D(corners[0].getX()-corners[1].getX(),
                corners[0].getY() - corners[1].getY()).norm();
    }

    public double getHeight() {
        return new Vector2D(corners[1].getX()-corners[2].getX(),
                corners[1].getY() - corners[2].getY()).norm();
    }

    public GRectangle rotate(double angle) {
        GPoint2D center = getCenter();
        GPoint2D[] points = getCorners();
        Vector2D[] vectors = new Vector2D[4];
        IMatrix<Float> rotation = new Matrix2f().rotation(angle);
        for(int i = 0; i < 4; i++) {
            vectors[i] = new Vector2D(center, points[i]);
            vectors[i] = vectors[i].multiply(rotation);
        }

        for(int i = 0; i < 4; i++) {
            points[i] = new GPoint2D(center.toVector2D().add(vectors[i]));
        }
        return new GRectangle(points);
    }
}
