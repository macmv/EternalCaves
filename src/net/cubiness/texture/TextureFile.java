package net.cubiness.texture;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public enum TextureFile {
	AIR("res/air.png"),
	STONE("res/stone.png"),
	SAND("res/sand.png");
	
	private final Texture tx;
	
	private TextureFile(String path) {
		try {
			this.tx = TextureLoader.getTexture("PNG", new FileInputStream(new File(path)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Texture getTexture() {
		return tx;
	}
	
}