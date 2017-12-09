package net.cubiness.world.board;

import java.util.HashMap;

import net.cubiness.tile.Material;
import net.cubiness.tile.Tile;
import net.cubiness.world.Location;

public class Grid {

	private HashMap<Location, Tile> grid = new HashMap<>();
	
	public Grid() {
		
	}
	
	public void setTileAt(Location l, Material m) {
		grid.put(l.round(), new Tile(l.round(), m));
	}
	
	public HashMap<Location, Tile> getGrid() {
		return grid;
	}

	public Tile getTileAt(Location pos) {
		Location l = pos.floor();
		if (grid.get(l) == null) {
			return new Tile(pos, Material.EMPTY);
		} else {
			return grid.get(l);
		}
	}
	
}
