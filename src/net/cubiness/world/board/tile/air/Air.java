package net.cubiness.world.board.tile.air;

import net.cubiness.texture.TextureFile;
import net.cubiness.world.Location;
import net.cubiness.world.board.tile.Tile;
import net.cubiness.world.generate.Biome;

public class Air extends Tile {

	public Air(Location l, Biome b) {
		super(l, b, TextureFile.AIR.getTexture());
	}

}
