package net.cubiness.world.hitbox;

import net.cubiness.world.Location;

public class Hitbox {
	
	private Location loc;
	private SubHitbox[] hitboxes;
	
	public Hitbox(Location loc, SubHitbox[] hitboxes) {
		this.loc = loc;
		this.hitboxes = hitboxes;
	}
	
	public SubHitbox[] getSubHitboxes() {
		return hitboxes;
	}
	
	private boolean isTouching(Hitbox other) {
		for(int i = 0; i < getSubHitboxes().length; i++) {
			for(int j = 0; j < other.getSubHitboxes().length; j++) {
				if (getSubHitboxes()[i].touching(other.getSubHitboxes()[j])) {
					return true;
				}
			}
		}
		return false;
	}
	
}
