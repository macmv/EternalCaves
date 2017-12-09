package net.cubiness.tile;

import net.cubiness.tile.types.air.Air;
import net.cubiness.tile.types.air.Empty;
import net.cubiness.tile.types.base.building.Sandstone;
import net.cubiness.tile.types.base.ore.Sand;
import net.cubiness.tile.types.base.ore.Stone;

public enum Material {

	AIR(Air.class.getName()),
	STONE(Stone.class.getName()),
	SAND(Sand.class.getName()),
	SANDSTONE(Sandstone.class.getName()),
	EMPTY(Empty.class.getName());
	
	private String myClass;
	
	Material(String myClass) {
		this.myClass = myClass;
	}
	
	public String getTileClassName() {
		return myClass;
	}
	
}
