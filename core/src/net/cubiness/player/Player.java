package net.cubiness.player;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import net.cubiness.Main;
import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.world.Location;
import net.cubiness.world.board.Grid;
import net.cubiness.world.generate.WorldBuilder;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.LocationAndVelocity;
import net.cubiness.world.hitbox.SubHitbox;

public class Player {

	private Location loc;
	private WorldBuilder builder;
	private float xVel;
	private float yVel;
	private Hitbox hitbox;
	private PlayerRender render = new PlayerRender();
	
	public Player(WorldBuilder builder, Grid grid) {
		loc = new Location(1, 1);
		this.builder = builder;
		xVel = 0f;
		yVel = 0f;
		builder.genBlockAt(loc);
		builder.genCircle(loc, 5, Material.AIR);
		grid.setTileAt(loc, Material.AIR);
		hitbox = new Hitbox(new ArrayList<SubHitbox>());
		hitbox.getSubHitboxes().add(new SubHitbox(new Location(0, 0), new Location(1, 1.5)));
	}

	public void update(long milisPassed) {
		if (Gdx.input.isKeyPressed(Input.Keys.W) && Main.b.getHitboxManager().canJump(this)) {
			yVel = 14f + Math.abs(xVel) / 3.8f;
		}
		yVel -= 0.5;
		LocationAndVelocity locAndVel = Main.b.getHitboxManager().playerMove(this,
													new Location(loc.getX(),
																loc.getY() - yVel * ((float) milisPassed / 1000f)),
													xVel,
													yVel);
		loc.setY(locAndVel.getLocation().getY());
		yVel = locAndVel.getYVel();
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			xVel -= 0.45f;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			xVel += 0.45f;
		}
		xVel *= 0.94;
		locAndVel = Main.b.getHitboxManager().playerMove(this,
													new Location(loc.getX() + xVel * ((float) milisPassed / 1000f),
																loc.getY()),
													xVel,
													yVel);
		loc.setX(locAndVel.getLocation().getX());
		xVel = locAndVel.getXVel();
		if (builder.getGrid().getTileAt(loc.round()).getMaterial().equals(Material.EMPTY)) {
			builder.genBlockAt(loc.round());
		}
	}
	
	public void render() {
		render.render(this);
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public void setLocation(Location l) {
		loc = l;
	}

	public Hitbox getHitbox() {
		return hitbox;
	}
	
}
