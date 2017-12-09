package net.cubiness.world.hitbox;

import net.cubiness.player.Player;
import net.cubiness.tile.Tile;
import net.cubiness.world.Location;
import net.cubiness.world.board.Board;

public class HitboxManager {

	private Board board;
	
	public HitboxManager(Board world) {
		board = world;
	}
	
	public LocationAndVelocity playerMove(Player player, Location moveTo, float xVel, float yVel) {
		Location blockLoc = moveTo.floor();
		Tile topLeftTile = board.getGrid().getTileAt(blockLoc);
		blockLoc.setX(blockLoc.getX() + 1);
		Tile topRightTile = board.getGrid().getTileAt(blockLoc);
		blockLoc.setX(blockLoc.getX() - 1);
		blockLoc.setY(blockLoc.getY() + 1);
		Tile bottomLeftTile = board.getGrid().getTileAt(blockLoc);
		blockLoc.setX(blockLoc.getX() + 1);
		Tile bottomRightTile = board.getGrid().getTileAt(blockLoc);
		boolean topLeft = topLeftTile.getHitbox().touching(moveTo, player.getHitbox());
		boolean topRight = topRightTile.getHitbox().touching(moveTo, player.getHitbox());
		boolean bottomLeft = bottomLeftTile.getHitbox().touching(moveTo, player.getHitbox());
		boolean bottomRight = bottomRightTile.getHitbox().touching(moveTo, player.getHitbox());
		if (topLeft || topRight || bottomLeft || bottomRight) {
			// TODO: make setX() and setY() calculate how much you need to move, rather than all or nothing
			moveTo.setX(player.getLocation().getX());
			xVel = 0f;
			moveTo.setY(player.getLocation().getY());
			yVel = 0f;
		}
		return new LocationAndVelocity(moveTo, xVel, yVel);
	}

	public boolean canJump(Player player) {
		Location blockLoc = new Location(player.getLocation().getX(), player.getLocation().getY());
		blockLoc.setY(blockLoc.getY() + player.getHitbox().getSubHitboxes().get(0).getBottomRight().getY() + 0.01f);
		Tile bottomLeftTile = board.getGrid().getTileAt(blockLoc);
		blockLoc.setX(blockLoc.getX() + 1);
		Tile bottomRightTile = board.getGrid().getTileAt(blockLoc);
		Location playerLoc = new Location(player.getLocation().getX(), player.getLocation().getY() + player.getHitbox().getSubHitboxes().get(0).getBottomRight().getY());
		boolean bottomLeft = bottomLeftTile.getHitbox().touching(playerLoc, player.getHitbox());
		boolean bottomRight = bottomRightTile.getHitbox().touching(playerLoc, player.getHitbox());
		return bottomLeft || bottomRight;
	}
	
}
