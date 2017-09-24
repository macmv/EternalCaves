package net.cubiness.world.board;

import net.cubiness.world.generate.WorldBuilder;

public class Board {
	
	private Grid grid;
	private WorldBuilder builder;
	
	public Board() {
		grid = new Grid();
		builder = new WorldBuilder(grid);
	}
	
	public void update() {
		
	}
	
	public Grid getGrid() {
		return grid;
	}

}
