package net.cubiness.tile.types.air;


import java.util.ArrayList;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.SubHitbox;

public class Air extends TileData {

	public Air() {
		super(Material.AIR, new Texture(new Pixmap(1, 1, Format.RGBA8888)), new Hitbox(new ArrayList<SubHitbox>()));
	}
	
	public void render(Location l) {
		
	}

}
