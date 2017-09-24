package net.cubiness.world.board.tile.base;

import net.cubiness.texture.TextureFile;
import net.cubiness.world.Location;
import net.cubiness.world.board.tile.Tile;
import net.cubiness.world.generate.Biome;

public class Stone extends Tile {

	public Stone(Location l) {
		super(l, Biome.BASIC, TextureFile.STONE.getTexture());
	}

}
