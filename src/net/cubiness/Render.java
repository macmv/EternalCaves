package net.cubiness;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;

import net.cubiness.world.Location;

public class Render {
	
	public Render() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 10, -10);
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_DST_COLOR);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDepthMask(false);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public static void renderImage(Texture t, Location l, boolean flipped) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, t.getTextureID());
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
	}
	
	public static void renderQuad(Location a, Location b, Location c, Location d, Color color, boolean outline) {
		GL11.glColor3f(color.getRed() / 255f, color.getGreen() / 255f, color.getBlue() / 255f);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		int xRes = Display.getWidth() / Main.TILE_WIDTH;
		int yRes = Display.getHeight() / Main.TILE_HEIGHT;

		GL11.glVertex2f(a.getX() * xRes, a.getY() * yRes);
		GL11.glVertex2f(b.getX() * xRes, b.getY() * yRes);
		GL11.glVertex2f(c.getX() * xRes, c.getY() * yRes);
		GL11.glVertex2f(d.getX() * xRes, d.getY() * yRes);
		
    	if (outline) {
    		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_LINE);
    		GL11.glColor3f(0, 0, 0);

    		GL11.glVertex2f(a.getX() * xRes, a.getY() * yRes);
    		GL11.glVertex2f(b.getX() * xRes, b.getY() * yRes);
    		GL11.glVertex2f(c.getX() * xRes, c.getY() * yRes);
    		GL11.glVertex2f(d.getX() * xRes, d.getY() * yRes);
    		
    		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
    	}
    	GL11.glColor3f(1, 1, 1);
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

		GL11.glPushMatrix();
    	GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		
		GL11.glBegin(GL11.GL_QUADS);
		Main.b.getGrid().getGrid().forEach((l, t) -> {
			t.render();
		});
		GL11.glEnd();
		Main.b.getPlayers().forEach((p) -> {
			renderImage(p.getTexture(), p.getLocation(), false);
		});

    	GL11.glDisable(GL11.GL_TEXTURE_2D);
    	GL11.glPopMatrix();
		//for (Enemy e : Main.b.getEnemies()) {
		//	renderImage(e.getTex(), e.getLocation(), e.needsFlip());
		//}
		//renderImage(Main.b.getPlayer1().getTex(), Main.b.getPlayer1().getLocation(), Main.b.getPlayer1().needsFlip());
		//if (!Main.b.getPlayer1().isAlive()) {
		//	
		//}
	}

}
