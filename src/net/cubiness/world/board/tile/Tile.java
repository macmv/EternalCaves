package net.cubiness.world.board.tile;

import org.newdawn.slick.opengl.Texture;

import net.cubiness.world.Location;
import net.cubiness.world.generate.Biome;

public abstract class Tile {
	
	protected Location l;
	protected Biome biome;
	protected Hitbox hitbox;
	protected Texture tex;
	
	protected Tile(Location l, Biome b, Texture t) {
		this.l = l;
		biome = b;
		this.tex = t;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public Location getLocation() {
		return l;
	}

}
