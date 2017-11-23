package net.cubiness.tile.types.base.ore;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.util.Color;

import net.cubiness.Render;
import net.cubiness.texture.TextureFile;
import net.cubiness.tile.Material;
import net.cubiness.tile.types.TileData;
import net.cubiness.world.Location;

public class Stone extends TileData {
	
	private ArrayList<ArrayList<Location>> textureMap = new ArrayList<>();
	private ArrayList<ArrayList<Color>> colors = new ArrayList<>();
	
	public Stone() {
		super(Material.STONE, TextureFile.STONE.getTexture());
		Random r = new Random();
		ArrayList<Location> row = new ArrayList<>();
		for (int x = 0; x <= 4; x += 1) {
			row.add(new Location((float) x * 0.25f, 0));
		}
		textureMap.add(row);
		for (int y = 1; y <= 3; y += 1) {
			row = new ArrayList<>();
			row.add(new Location(0f, (float) y * 0.25f));
			for (int x = 1; x <= 3; x += 1) {
				row.add(new Location((float) x * 0.25f + r.nextFloat() / 5f - 0.1f, (float) y * 0.25f + r.nextFloat() / 5f - 0.1f));
			}
			row.add(new Location(1f, (float) y * 0.25f));
			textureMap.add(row);
		}
		row = new ArrayList<>();
		for (int x = 0; x <= 4; x += 1) {
			row.add(new Location((float) x * 0.25f, 1f));
		}
		textureMap.add(row);
		for (int y = 0; y <= 4; y += 1) {
			ArrayList<Color> color_row = new ArrayList<>();
			for (int x = 0; x <= 4; x += 1) {
				color_row.add(new Color(150 + r.nextInt(10), 100 + r.nextInt(10), 40 + r.nextInt(10)));
			}
			colors.add(color_row);
		}
	}
	
	public void render(Location l) {
		for (int y = 0; y < textureMap.size() - 1; y++) {
			for (int x = 0; x < textureMap.get(y).size() - 1; x++) {
				Render.renderQuad(
						textureMap.get(y).get(x).plus(l),
						textureMap.get(y).get(x + 1).plus(l),
						textureMap.get(y + 1).get(x + 1).plus(l),
						textureMap.get(y + 1).get(x).plus(l),
						colors.get(y).get(x),
						false);
			}
		}
	}

}