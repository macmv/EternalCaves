package net.cubiness.world.board;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			grid.setTileAt(new Location(Gdx.input.getX() / (Gdx.graphics.getWidth() / Main.TILE_WIDTH),
									    Gdx.input.getY() / (Gdx.graphics.getHeight() / Main.TILE_HEIGHT)),
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
