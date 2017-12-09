package net.cubiness.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import net.cubiness.Render;

public class PlayerRender {

	private Texture body = new Texture(Gdx.files.internal("player/body.png"));
	private Texture arm = new Texture(Gdx.files.internal("player/arm.png"));
	private Texture leg = new Texture(Gdx.files.internal("player/leg.png"));
	
	public void render(Player player) {
		Render.renderImage(body, player.getLocation(), 1, 2);
	}
	
}
