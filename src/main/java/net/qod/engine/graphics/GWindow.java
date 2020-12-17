package net.qod.engine.graphics;

import net.qod.engine.log.Logger;
import net.qod.engine.math.geom.GRectangle;
import net.qod.engine.math.geom.InsufficientPointException;
import net.qod.engine.mechanics.GameObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GWindow extends JFrame {
    public final int WIDTH, HEIGHT;
    public GRectangle frame;
    public final Logger logger;
    public final ArrayList<GameObject> objects;

    public Graphics dbg;
    public Image dbi;

    public GWindow(String text, int width, int height) {
        super(text);
        logger = new Logger(System.out);
        this.WIDTH = width;
        this.HEIGHT = height;

        try {
            frame = new GRectangle(
                    new double[]{0, WIDTH, WIDTH, 0},
                    new double[]{0, 0, HEIGHT, HEIGHT});
        } catch(InsufficientPointException e) {
            logger.error("Could not instantiate Frame!");
        }
        objects = new ArrayList<>();

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        logger.info("Created Window");
    }

    public Logger getLogger() {
        return logger;
    }

    public void addNode(GameObject object) {
        logger.debug("Added Game Object");
        objects.add(object);
    }

    public void prepareScreen() {
        dbi = createImage(WIDTH, HEIGHT);
        dbg = dbi.getGraphics();
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, WIDTH, HEIGHT);
        dbg.setColor(getForeground());
        render(dbg);
    }

    public void paint(Graphics g) {
        g.drawImage(dbi, 0, 0, this);
    }

    public void render(Graphics g) {
        objects.forEach(o -> {
            if(o instanceof GraphicalObject) ((GraphicalObject) o).paint(g);
        });
    }
}
