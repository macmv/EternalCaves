package net.cubiness;

import org.lwjgl.Version;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Main {

	// The window handle
	public static int WIDTH = 680;
	public static int HEIGHT = 460;
	private static Render r;

	private static void init() {
		r = new Render();
	}

	private static void loop() {
		while (!GLFW.glfwWindowShouldClose(r.window) && GLFW.glfwGetKey(r.window, GLFW.GLFW_KEY_ESCAPE ) != GLFW.GLFW_PRESS) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			r.render();
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello LWJGL " + Version.getVersion() + "!");
		init();
		loop();
		Callbacks.glfwFreeCallbacks(r.window);
		GLFW.glfwDestroyWindow(r.window);
		GLFW.glfwTerminate();
		GLFW.glfwSetErrorCallback(null).free();
	}	

}