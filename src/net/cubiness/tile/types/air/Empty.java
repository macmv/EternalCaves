package net.cubiness.tile.types.air;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;

public class Empty extends TileData {

	public Empty() {
		super(Material.EMPTY, TextureFile.AIR.getTexture());
	}

}
