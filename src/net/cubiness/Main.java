package net.cubiness;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import net.cubiness.world.board.Board;

public class Main {

	// The window handle
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	public static int TILE_WIDTH = 48;
	public static int TILE_HEIGHT = 27;
	public static Board b;

	public static void main(String[] args) {
		try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Bit Platformer");
            Display.create();
            Display.setResizable(true);
        } catch (LWJGLException e) {
            System.err.println("Display wasn't initialized correctly.");
            e.printStackTrace();
            System.exit(1);
        }
        Render r = new Render();
		b = new Board();
        while (!Display.isCloseRequested()) {
        	r.render();
        	b.update();
        	Display.update();
        	Display.sync(60);
        }
        Display.destroy();
        System.exit(0);
	} 	

}