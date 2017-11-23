package net.cubiness.world.board;

import java.util.ArrayList;

import net.cubiness.player.Player;
import net.cubiness.world.generate.WorldBuilder;
import net.cubiness.world.hitbox.HitboxManager;

public class Board {
	
	private Grid grid;
	private WorldBuilder builder;
	private ArrayList<Player> players = new ArrayList<>();
	private HitboxManager hitboxManager = new HitboxManager(this);
	
	public Board() {
		grid = new Grid();
		builder = new WorldBuilder(grid);
		players.add(new Player(builder));
	}
	
	public void update() {
		players.forEach((p) -> {
			p.update();
		});
	}
	
	public Grid getGrid() {
		return grid;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public HitboxManager getHitboxManager() {
		return hitboxManager;
	}

}
