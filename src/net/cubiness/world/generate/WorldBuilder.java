package net.cubiness.world.generate;

import net.cubiness.world.Location;
import net.cubiness.world.board.Grid;
import net.cubiness.world.board.tile.base.Stone;

public class WorldBuilder {
	
	private Grid grid;
	
	public WorldBuilder(Grid g) {
		grid = g;
	}
	
	private void genBlock(Location l) {
		grid.setTileAt(l, new Stone(l));
	}

}
