package net.cubiness;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import net.cubiness.world.Location;
import net.cubiness.world.board.tile.Tile;
import net.cubiness.world.board.tile.base.Sand;
import net.cubiness.world.board.tile.base.Stone;

public class Render {
	
	public Render() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_DST_COLOR);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDepthMask(false);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private static void renderImage(Texture t, Location l, boolean flipped) {
		GL11.glPushMatrix();
    	GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, t.getTextureID());
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		int xRes = Display.getWidth() / Main.TILE_WIDTH;
		int yRes = Display.getHeight() / Main.TILE_HEIGHT;
		int a;
		int b;
		if (flipped) {
			a = 1;
			b = 0;
		} else {
			a = 0;
			b = 1;
		}
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2f(a, 0); GL11.glVertex2f(l.getX() * xRes,        l.getY() * yRes       );
		GL11.glTexCoord2f(a, 1); GL11.glVertex2f(l.getX() * xRes,        l.getY() * yRes + yRes);
		GL11.glTexCoord2f(b, 1); GL11.glVertex2f(l.getX() * xRes + xRes, l.getY() * yRes + yRes);
		GL11.glTexCoord2f(b, 0); GL11.glVertex2f(l.getX() * xRes + xRes, l.getY() * yRes       );
		
    	GL11.glEnd();
    	GL11.glDisable(GL11.GL_TEXTURE_2D);
    	GL11.glPopMatrix();
	}

	public void render() {
		if (Display.wasResized()) {
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
			GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
		}
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glColor3f(0f, .3f, .6f);
		GL11.glRecti(0, 0, Display.getWidth(), Display.getHeight());
		GL11.glColor3f(1f, 1f, 1f);
		//Main.b.getGrid().getGrid().forEach((l, t) -> {
		Tile t = new Sand(new Location(1, 1));
		renderImage(t.getTexture(), t.getLocation(), false);
		t = new Stone(new Location(1, 0));
		renderImage(t.getTexture(), t.getLocation(), false);
		t = new Stone(new Location(0, 1));
		renderImage(t.getTexture(), t.getLocation(), false);
		//});
		//for (Enemy e : Main.b.getEnemies()) {
		//	renderImage(e.getTex(), e.getLocation(), e.needsFlip());
		//}
		//renderImage(Main.b.getPlayer1().getTex(), Main.b.getPlayer1().getLocation(), Main.b.getPlayer1().needsFlip());
		//if (!Main.b.getPlayer1().isAlive()) {
		//	
		//}
	}

}
