package net.cubiness.tile.types.base.ore;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;
import net.cubiness.world.hitbox.Hitbox;
import net.cubiness.world.hitbox.SubHitbox;

public class Sand extends TileData {

	public Sand() {
		super(Material.SAND, new Texture(new Pixmap(1, 1, Format.RGBA8888)), new Hitbox(new ArrayList<SubHitbox>()));
		hitbox.getSubHitboxes().add(new SubHitbox(new Location(0, 0), new Location(1, 1)));
	}

}
