package net.cubiness.tile.types.air;

import java.util.ArrayList;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.SubHitbox;

public class Empty extends TileData {

	public Empty() {
		super(Material.EMPTY, TextureFile.AIR.getTexture(), new Hitbox(new ArrayList<SubHitbox>()));
	}

}
