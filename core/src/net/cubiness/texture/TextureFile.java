package net.cubiness.texture;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum TextureFile {
	
	STONE("stone.png"),
	SANDSTONE("sandstone.png"),
	//COAL("res/coal.png"),
	//IRON("res/iron.png"),
	//BAUXITE("res/bauxite.png"),
	;
	
	private final Texture tx;
	
	private TextureFile(String path) {
		this.tx = new Texture(Gdx.files.internal(path));
	}
	
	public Texture getTexture() {
		return tx;
	}
	
}