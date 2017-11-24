package net.cubiness.world.hitbox;

import net.cubiness.world.Location;

public class SubHitbox {

	private Location topLeft, bottomRight;
	
	public SubHitbox(Location topLeft, Location bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public boolean touching(Location loc, Location otherLoc, SubHitbox other) {
		// check this hitbox 
		Location tempTopLeft = topLeft.plus(loc);
		Location tempBottomRight = bottomRight.plus(loc);
		Location tempTopLeftOther = other.topLeft.plus(otherLoc);
		Location tempBottomRightOther = other.bottomRight.plus(otherLoc);
		return ((tempTopLeft.getX() >= tempTopLeftOther.getX() &&
				tempTopLeft.getX() <= tempBottomRightOther.getX()) ||
				(tempBottomRight.getX() >= tempTopLeftOther.getX() &&
				tempBottomRight.getX() <= tempBottomRightOther.getX()) ||
				// check other hitbox x
				(tempTopLeftOther.getX() >= tempTopLeft.getX() &&
				tempTopLeftOther.getX() <= tempBottomRight.getX()) ||
				(tempBottomRightOther.getX() >= tempTopLeft.getX() &&
				tempBottomRightOther.getX() <= tempBottomRight.getX())) &&
				// check one this y
				((tempTopLeft.getY() >= tempTopLeftOther.getY() &&
				tempTopLeft.getY() <= other.getBottomRight().getY()) ||
				(tempBottomRight.getY() >= tempTopLeftOther.getY() &&
				tempBottomRight.getY() <= other.getBottomRight().getY()) ||
				// check other hitbox y
				(tempTopLeftOther.getY() >= tempTopLeft.getY() &&
				tempTopLeftOther.getY() <= tempBottomRight.getY()) ||
				(tempBottomRightOther.getY() >= tempTopLeft.getY() &&
				tempBottomRightOther.getY() <= tempBottomRight.getY()));
	}

	public Location getTopLeft() {
		return topLeft;
	}

	public Location getBottomRight() {
		return bottomRight;
	}

}
