package net.cubiness.player;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import net.cubiness.Main;
import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.world.Location;
import net.cubiness.world.generate.WorldBuilder;

public class Player {

	private Location loc;
	private WorldBuilder builder;
	private float xVel;
	private float yVel;
	
	public Player(WorldBuilder builder) {
		loc = new Location(0, 0);
		this.builder = builder;
		xVel = 0f;
		yVel = 0f;
	}

	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yVel -= 0.01;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xVel -= 0.01;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yVel += 0.01;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xVel += 0.01;
		}
		xVel *= 0.94;
		loc = Main.b.getHitboxManager().playerMove(this, new Location(loc.getX() + xVel, loc.getY() + yVel));
		if (builder.getGrid().getTileAt(loc.round()).getMaterial().equals(Material.EMPTY)) {
			builder.genBlockAt(loc.round());
		}
	}
	
	public Texture getTexture() {
		return TextureFile.STONE.getTexture();
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void setLocation(Location l) {
		loc = l;
	}
	
}
