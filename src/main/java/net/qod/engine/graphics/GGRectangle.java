package net.qod.engine.graphics;

import net.qod.engine.math.geom.GRectangle;
import net.qod.engine.math.geom.InsufficientPointException;
import net.qod.engine.math.vector.Matrix2f;
import net.qod.engine.math.vector.Vector2D;

import java.awt.*;

public class GGRectangle extends GraphicalObject {
    GRectangle rectangle;

    /**
     * Creates a Graphical Game Object: Rectangle
     * @param window backwards reference to parent
     * @param position Position Vector
     * @param a Width Vector
     * @param b Height Vector
     */
    public GGRectangle(GWindow window, Vector2D position, Vector2D a, Vector2D b) {
        super(window);
        this.position = position;
        this.facing = a.unit();

        rectangle = calculateBounds(a, b);
        addValueChangeListener(this::recompute);
        window.getLogger().debug("Initialized " + toString());
    }

    public void recompute() {
        Vector2D width = this.facing.scale(rectangle.getWidth());
        Vector2D height = this.facing.scale(rectangle.getHeight()).multiply(
                new Matrix2f().rotation(-90));

        rectangle = calculateBounds(width, height);
    }

    GRectangle calculateBounds(Vector2D width, Vector2D height) {
        Vector2D dia = width.add(height);
        Vector2D c = position.sub(dia.scale(0.5)),
                 d = c.add(width),
                 e = position.add(dia.scale(0.5)),
                 f = position.add(dia.scale(0.5)).sub(width);
        double[] x = new double[]{c.getX(), d.getX(), e.getX(), f.getX()};
        double[] y = new double[]{c.getY(), d.getY(), e.getY(), f.getY()};
        try {
            return new GRectangle(x, y);
        } catch (InsufficientPointException insufficientPointException) {
            container.getLogger().error("Could not instantiate Rectangle Object!");
        }
        return null;
    }

    @Override
    public void paint(Graphics g) {
        g.fillPolygon(new int[]{
                (int) rectangle.getCorners()[0].getX(),
                (int) rectangle.getCorners()[1].getX(),
                (int) rectangle.getCorners()[2].getX(),
                (int) rectangle.getCorners()[3].getX(),
        }, new int[]{
                (int) rectangle.getCorners()[0].getY(),
                (int) rectangle.getCorners()[1].getY(),
                (int) rectangle.getCorners()[2].getY(),
                (int) rectangle.getCorners()[3].getY(),
        }, 4);
        if(DEBUG) {
            g.setColor(Color.RED);
            g.drawLine((int)position.getX(), (int)position.getY(),
                    (int)position.add(facing.scale(10)).getX(),
                    (int)position.add(facing.scale(10)).getY());
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public String toString() {
        return "Rectangle: {" +
                position + " - " +
                rectangle.getCorners()[1].toVector2D() + " - " +
                rectangle.getCorners()[2].toVector2D() + " - " +
                rectangle.getCorners()[3].toVector2D() + '}';
    }
}
