package net.qod.game;

import net.qod.engine.graphics.GGLine;
import net.qod.engine.graphics.GGRectangle;
import net.qod.engine.graphics.GWindow;
import net.qod.engine.graphics.event.RepaintTimer;
import net.qod.engine.math.vector.Vector2D;
import net.qod.engine.mechanics.event.GameLoopTimer;

public class Game extends GWindow implements Runnable {
    GGLine line;
    GGRectangle rect;

    public Game(String text, int width, int height) {
        super(text, width, height);
    }

    public static void main(String[] args) {
        Game game = new Game("Test Game", 640, 400);

        game.line = new GGLine(game,
                new Vector2D(320, 200),
                new Vector2D(500, 200));

        game.rect = new GGRectangle(game,
                new Vector2D(100, 100),
                new Vector2D(40, 0),
                new Vector2D(0, 20)
        );

        game.rect.toggleDebug();

        new RepaintTimer(game, 50);
        new GameLoopTimer(game, 100);
    }

    @Override
    public void run() {
        line.rotate(1.0);
        rect.rotate(1.0);
    }
}
