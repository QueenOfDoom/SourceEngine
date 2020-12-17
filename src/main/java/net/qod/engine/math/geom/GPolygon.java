package net.qod.engine.math.geom;

public class GPolygon {
    GPoint2D[] corners;
    public GPolygon(GPoint2D[] corners) {
        this.corners = corners;
    }

    public GPolygon(double[] x, double[] y, int count) throws InsufficientPointException {
        if(x.length != y.length && y.length != count) {
            throw new InsufficientPointException(count,
                    (x.length == count) ? y.length : x.length);
        } else {
            GPoint2D[] points = new GPoint2D[count];
            for(int i = 0; i < points.length; i++) {
                points[i] = new GPoint2D(x[i], y[i]);
            }
            this.corners = points;
        }
    }

    public GPoint2D[] getCorners() {
        return corners;
    }

    public GPoint2D getCenter() {
        double x = 0, y = 0;
        for(GPoint2D p:corners) {
            x += p.getX();
            y += p.getY();
        }
        return new GPoint2D(x/corners.length, y/corners.length);
    }
}
