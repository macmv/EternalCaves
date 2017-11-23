package net.cubiness.tile.types;

import org.newdawn.slick.opengl.Texture;

import net.cubiness.tile.Material;
import net.cubiness.world.Location;

public abstract class TileData {
	
	protected Texture tex;
	protected Material material;
	
	public TileData(Material material, Texture tex) {
		this.material = material;
		this.tex = tex;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void render(Location l) {
		
	}

}
