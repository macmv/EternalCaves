package net.cubiness.tile.types.base.ore;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;

public class Sand extends TileData {

	public Sand() {
		super(Material.SAND, TextureFile.SAND.getTexture());
	}

}
