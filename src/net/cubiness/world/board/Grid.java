package net.cubiness.world.board;

import java.util.HashMap;

import net.cubiness.world.Location;
import net.cubiness.world.board.tile.Tile;

public class Grid {

	private HashMap<Location, Tile> grid = new HashMap<>();
	
	public Grid() {
		
	}
	
	public void setTileAt(Location l, Tile tile) {
		grid.put(l, tile);
	}
	
	public HashMap<Location, Tile> getGrid() {
		return grid;
	}
	
}
