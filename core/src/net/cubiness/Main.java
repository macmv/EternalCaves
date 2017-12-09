package net.cubiness;

import net.cubiness.world.board.Board;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends ApplicationAdapter {
    
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;
    public static int TILE_WIDTH = 48;
    public static int TILE_HEIGHT = 27;
    public static Board b;
    private static Render r;
    public static SpriteBatch batch;

    @Override
    public void create () {
        batch = new SpriteBatch();
        r = new Render();
        b = new Board();
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        b.update();
        batch.begin();
        // batch.draw(img, 0, 0);
        r.render();
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}