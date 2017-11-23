package net.cubiness.world.hitbox;

import net.cubiness.world.Location;

public class SubHitbox {

	private Location topLeft, bottomRight;
	
	public SubHitbox(Location topLeft, Location bottomRight) {
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	public boolean touching(SubHitbox other) {
		// checkthis hitbox 
		return (this.topLeft.getX() > other.getTopLeft().getX() &&
		this.topLeft.getX() < other.getBottomRight().getX()) ||
		(this.bottomRight.getX() > other.getTopLeft().getX() &&
		this.bottomRight.getX() < other.getBottomRight().getX()) ||
		// check other hitbox x
		(other.topLeft.getX() > this.getTopLeft().getX() &&
		other.topLeft.getX() < this.getBottomRight().getX()) ||
		(other.bottomRight.getX() > this.getTopLeft().getX() &&
		other.bottomRight.getX() < this.getBottomRight().getX()) &&
		// check one this y
		(this.topLeft.getY() > other.getTopLeft().getY() &&
		this.topLeft.getY() < other.getBottomRight().getY()) ||
		(this.bottomRight.getY() > other.getTopLeft().getY() &&
		this.bottomRight.getY() < other.getBottomRight().getY()) ||
		// check other hitbox y
		(other.topLeft.getY() > this.getTopLeft().getY() &&
		other.topLeft.getY() < this.getBottomRight().getY()) ||
		(other.bottomRight.getY() > this.getTopLeft().getY() &&
		other.bottomRight.getY() < this.getBottomRight().getY());
	}

	public Location getTopLeft() {
		return topLeft;
	}

	public Location getBottomRight() {
		return bottomRight;
	}

}
