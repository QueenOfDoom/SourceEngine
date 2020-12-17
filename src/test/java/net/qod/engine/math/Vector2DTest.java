package net.qod.engine.math;

import net.qod.engine.math.vector.Vector2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest {

    @Test
    void getX() {
        Vector2D vec = new Vector2D(2, 3);
        assertEquals(2.0, vec.getX());
    }

    @Test
    void getY() {
        Vector2D vec = new Vector2D(2, 3);
        assertEquals(3.0, vec.getY());
    }

    @Test
    void norm() {
        Vector2D vec = new Vector2D(3, 4);
        assertEquals(5.0, vec.norm());
    }

    @Test
    void add() {
        Vector2D vec1 = new Vector2D(1, 2);
        Vector2D vec2 = new Vector2D(3, 4);
        Vector2D vec3 = new Vector2D(5, 6);
        vec1.add(vec2).add(vec3);
        assertEquals(9.0, vec1.getX());
        assertEquals(12.0, vec1.getY());
    }

    @Test
    void unit() {
        Vector2D vec1 = new Vector2D(1, 1).unit();
        // Approximations
        assertTrue(Math.abs(1.0-vec1.norm()) < 0.1);
        assertTrue(Math.abs(Math.sqrt(2)/2.0 - vec1.getX()) < 0.0000001);
    }
}