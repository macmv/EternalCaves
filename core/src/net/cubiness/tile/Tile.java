package net.cubiness.tile;

import com.badlogic.gdx.graphics.Texture;

import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;
import net.cubiness.world.generate.Biome;
import net.cubiness.world.hitbox.Hitbox;

public class Tile {
	
	protected Location loc;
	protected Biome biome;
	protected Hitbox hitbox;
	protected TileData type = null;
	
	public Tile(Location l, Material m) {
		this.loc = l;
		try {
			type = (TileData) Class.forName(m.getTileClassName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		type.setLocation(loc);
	}
	
	public void render() {
		type.render(loc);
	}
	
	public Texture getTexture() {
		return type.getTexture();
	}
	
	public Location getLocation() {
		return loc;
	}

	public Material getMaterial() {
		return type.getMaterial();
	}
	
	public Hitbox getHitbox() {
		return type.getHitbox();
	}

}
