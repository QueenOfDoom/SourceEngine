package net.qod.engine.graphics;

import net.qod.engine.math.vector.Vector2D;

import java.awt.*;

public class GGLine extends GraphicalObject {

    public GGLine(GWindow window, Vector2D start, Vector2D end) {
        super(window);
        position = start;
        facing = end.add(start.negate());
        window.getLogger().debug("Initialized " + toString());
    }

    @Override
    public String toString() {
        return "Line: {" +
                "Start:" + position +
                ", End:" + facing +
                '}';
    }

    @Override
    public void paint(Graphics g) {
        Vector2D end = position.add(facing);
        g.drawLine((int) position.getX(), (int) position.getY(), (int) end.getX(), (int) end.getY());
    }
}
