package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import net.cubiness.Main;

public class DesktopLauncher {
	
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
        config.title = "Bit Platformer";
        config.resizable = true;
		new LwjglApplication(new Main(), config);
		
	}
	
}
