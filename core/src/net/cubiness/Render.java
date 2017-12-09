package net.cubiness;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import net.cubiness.world.Location;

public class Render {
	
    private Texture background;
    
    public Render() {
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        pixmap.setColor(new Color(0f, 0.3f, 0.6f, 1f));
        pixmap.fill();
        background = new Texture(pixmap);
    }
    
    public static void renderTile(Texture t, Location loc) { // location is on grid
        renderImage(t, loc, 1, 1);
    }

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Main.batch.draw(background, 0, 0);
        Main.b.getGrid().getGrid().forEach((l, t) -> {
            t.render();
        });
		Main.b.getPlayers().forEach((p) -> {
		    p.render();
		});
	}

	public static void renderImage(Texture t, Location loc, double w, double h) {
		Location l = loc.copy();
        l.setY(l.getY() * -1 + Main.TILE_HEIGHT);
        float xRes = Main.WIDTH / Main.TILE_WIDTH;
        float yRes = Main.HEIGHT / Main.TILE_HEIGHT;
        l.setX(l.getX() * xRes);
        l.setY(l.getY() * yRes);
        Main.batch.draw(t, (float) l.getX(), (float) l.getY(), (float) w * xRes, (float) h * yRes);
	}

}
