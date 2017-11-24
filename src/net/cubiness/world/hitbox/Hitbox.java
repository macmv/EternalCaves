package net.cubiness.world.hitbox;

import java.util.ArrayList;

import net.cubiness.world.Location;

public class Hitbox {
	
	private Location loc;
	private ArrayList<SubHitbox> hitboxes;

	public Hitbox(ArrayList<SubHitbox> hitboxes) {
		this.hitboxes = hitboxes;
	}

	public ArrayList<SubHitbox> getSubHitboxes() {
		return hitboxes;
	}
	
	public boolean touching(Location otherLoc, Hitbox other) {
		for(SubHitbox thisHitbox : hitboxes) {
			for(SubHitbox otherHitbox : other.hitboxes) {
				if (thisHitbox.touching(loc, otherLoc, otherHitbox)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return loc;
	}
	
}
