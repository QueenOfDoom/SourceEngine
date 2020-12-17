package net.qod.engine.graphics;

import net.qod.engine.graphics.event.ValueChangeListener;
import net.qod.engine.math.vector.Matrix2f;
import net.qod.engine.math.vector.Vector2D;
import net.qod.engine.mechanics.GameObject;

import java.awt.*;
import java.util.ArrayList;

public abstract class GraphicalObject extends GameObject {
    boolean DEBUG;
    ArrayList<ValueChangeListener> listeners;
    Vector2D position, facing;
    Vector2D[] hitBox;
    GWindow container;

    public GraphicalObject(GWindow window) {
        this.container = window;
        listeners = new ArrayList<>();
        window.addNode(this);
    }

    public void addValueChangeListener(ValueChangeListener listener) {
        listeners.add(listener);
    }

    public void rotate(double angle) {
        facing = facing.multiply(new Matrix2f().rotation(angle));
        listeners.forEach(ValueChangeListener::trigger);
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getFacing() {
        return facing;
    }

    public abstract void paint(Graphics g);

    public void toggleDebug() {
        DEBUG = !DEBUG;
    }
}
