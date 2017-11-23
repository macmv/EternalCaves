package net.cubiness.tile;

import org.newdawn.slick.opengl.Texture;

import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;
import net.cubiness.world.generate.Biome;
import net.cubiness.world.hitbox.Hitbox;

public class Tile {
	
	protected Location l;
	protected Biome biome;
	protected Hitbox hitbox;
	protected TileData type = null;
	
	public Tile(Location l, Material m) {
		this.l = l;
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
	}
	
	public void render() {
		type.render(l);
	}
	
	public Texture getTexture() {
		return type.getTexture();
	}
	
	public Location getLocation() {
		return l;
	}

	public Material getMaterial() {
		return type.getMaterial();
	}

}
