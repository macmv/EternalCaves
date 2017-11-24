package net.cubiness.tile.types.base.ore;

import java.util.ArrayList;

import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.SubHitbox;

public class Sand extends TileData {

	public Sand() {
		super(Material.SAND, TextureFile.SAND.getTexture(), new Hitbox(new ArrayList<SubHitbox>()));
		super.hitbox.getSubHitboxes().add(new SubHitbox(new Location(0, 0), new Location(1, 1)));
	}

}
