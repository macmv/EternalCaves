package net.cubiness.world.generate;

import java.util.Random;

import net.cubiness.tile.Material;
import net.cubiness.world.Location;
import net.cubiness.world.board.Grid;

public class WorldBuilder {
	
	private Grid grid;
	
	public WorldBuilder(Grid g) {
		grid = g;
	}
	
	@SuppressWarnings("unused")
	private void genBiome(Location l) {
		int maxCircleSize = 8;
		int minCircleSize = 5;
		Random rand = new Random();
		Material material = (new Material[] { Material.STONE, Material.SANDSTONE })[rand.nextInt(2)];
		Material oreMaterial = (new Material[] { Material.STONE, Material.SAND })[rand.nextInt(2)];
		genCircle(l, maxCircleSize + 2, material);
		for (int i = 0; i < 5; i++) {
			genCircle(new Location(l.getX() + rand.nextInt(20) - 10,
								   l.getY() + rand.nextInt(20) - 10),
					  rand.nextInt(maxCircleSize - minCircleSize) + minCircleSize, material);
			genCircle(new Location(l.getX() + rand.nextInt(20) - 10,
					   			   l.getY() + rand.nextInt(20) - 10),
					  rand.nextInt(maxCircleSize - minCircleSize) + minCircleSize, Material.AIR);
			genCircle(new Location(l.getX() + rand.nextInt(20) - 10,
					   			   l.getY() + rand.nextInt(20) - 10),
					  (rand.nextInt(maxCircleSize - minCircleSize) + minCircleSize) / 2, Material.AIR);
		}
	}
	
	public void genCircle(Location l, int size, Material material) {
		l = l.floor();
		int biomeSize = 12;
		for (int y = (int) l.getY() - biomeSize; y < l.getY() + biomeSize; y++) {
			for (int x = (int) l.getX() - biomeSize; x < l.getX() + biomeSize; x++) {
				if (distance(x, y, l.getX(), l.getY()) < size && grid.getTileAt(new Location(x, y)).getMaterial().equals(Material.EMPTY)) {
					grid.setTileAt(new Location(x, y), material);
				}
			}
		}
	}
	
	private double distance(float x1, float y1, float x2, float y2) {
		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
	}
	
	public void genBlockAt(Location l) {
		if (grid.getTileAt(l).getMaterial().equals(Material.EMPTY)) {
			
			// for testing a single block, comment out the genBiome(newL); line,
			// and uncomment the line below this
			
			//grid.setTileAt(l, Material.SANDSTONE);
			Location newL = new Location((int) (l.getX() / 10), (int) (l.getY() / 10));
			newL.setX(newL.getX() * 10);
			newL.setY(newL.getY() * 10);
			genBiome(newL);
		}
	}

	public Grid getGrid() {
		return grid;
	}

}
