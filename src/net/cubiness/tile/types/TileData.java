package net.cubiness.tile.types;

import org.newdawn.slick.opengl.Texture;

import net.cubiness.tile.Material;
import net.cubiness.world.Location;
import net.cubiness.world.hitbox.Hitbox;

public abstract class TileData {
	
	protected Texture tex;
	protected Material material;
	protected Hitbox hitbox;
	
	public TileData(Material material, Texture tex, Hitbox hitbox) {
		this.material = material;
		this.tex = tex;
		this.hitbox = hitbox;
	}
	
	public Texture getTexture() {
		return tex;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void render(Location l) {
		
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	public void setLocation(Location loc) {
		hitbox.setLocation(loc);
	}

}
