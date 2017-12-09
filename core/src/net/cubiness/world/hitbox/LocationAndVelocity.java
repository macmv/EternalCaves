package net.cubiness.world.hitbox;

import net.cubiness.world.Location;

public class LocationAndVelocity {

	private Location loc;
	private float xVel, yVel;
	
	public LocationAndVelocity(Location loc, float xVel, float yVel) {
		this.loc = loc;
		this.xVel = xVel;
		this.yVel = yVel;
	}

	public Location getLocation() {
		return loc;
	}

	public void setLocation(Location loc) {
		this.loc = loc;
	}

	public float getXVel() {
		return xVel;
	}

	public void setXVel(float xVel) {
		this.xVel = xVel;
	}

	public float getYVel() {
		return yVel;
	}

	public void setYVel(float yVel) {
		this.yVel = yVel;
	}
	
}
