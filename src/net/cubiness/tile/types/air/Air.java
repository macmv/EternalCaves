package net.cubiness.tile.types.air;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;

public class Air extends TileData {

	public Air() {
		super(Material.AIR, TextureFile.AIR.getTexture());
	}

}
