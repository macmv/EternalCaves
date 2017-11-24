package net.cubiness.tile.types.air;


import java.util.ArrayList;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.SubHitbox;

public class Air extends TileData {

	public Air() {
		super(Material.AIR, TextureFile.AIR.getTexture(), new Hitbox(new ArrayList<SubHitbox>()));
	}

}
