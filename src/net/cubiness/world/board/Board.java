package net.cubiness.world.board;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import net.cubiness.Main;
import net.cubiness.player.Player;
import net.cubiness.tile.Material;
import net.cubiness.world.Location;
import net.cubiness.world.generate.WorldBuilder;
import net.cubiness.world.hitbox.HitboxManager;

public class Board {
	
	private Grid grid;
	private WorldBuilder builder;
	private ArrayList<Player> players = new ArrayList<>();
	private HitboxManager hitboxManager = new HitboxManager(this);
	private long lastMili = System.currentTimeMillis();
	
	public Board() {
		grid = new Grid();
		builder = new WorldBuilder(grid);
		players.add(new Player(builder, grid));
	}
	
	public void update() {
		players.forEach((p) -> {
			long currentMili = System.currentTimeMillis();
			p.update(currentMili - lastMili);
			lastMili = currentMili;
		});
		if (Mouse.isButtonDown(0)) {
			grid.setTileAt(new Location(Mouse.getX() / (Display.getWidth() / Main.TILE_WIDTH),
									   (Mouse.getY() * -1 + Display.getHeight()) / (Display.getHeight() / Main.TILE_HEIGHT)),
						   Material.AIR);
		}
	}
	
	public void onClick() {
		
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
