package net.cubiness;

import java.awt.Point;
import java.util.HashMap;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Render {
	
	private HashMap<Point, Integer> zVals = new HashMap<>();
	private Texture tex;
	public long window;
	private int[] vertexbuffer = { 1 };
	
	public Render() {
		GLFWErrorCallback.createPrint(System.err).set();
		if ( !GLFW.glfwInit() ) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, 4);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, 1); // To make MacOS happy; should not be needed
		GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE); // We don't want the old OpenGL 
		window = GLFW.glfwCreateWindow(Main.WIDTH, Main.HEIGHT, "Hello World!", 0, 0);
		if ( window == 0 ) {
			throw new RuntimeException("Failed to create the GLFW window");
		}
		GLFW.glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if ( key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE )
				GLFW.glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});
		GLFW.glfwMakeContextCurrent(window);
		GLFW.glfwSwapInterval(1);
		GL.createCapabilities();
		GLFW.glfwSetInputMode(window, GLFW.GLFW_STICKY_KEYS, 1);
		init();
	}
	
	private void init() {
		//float vertices[] = {
		//	100f,  200f, // Vertex 1 (X, Y)
		//	200f,  0f, // Vertex 2 (X, Y)
		//	0f, 0f  // Vertex 3 (X, Y)
		//};
		//GL15.glGenBuffers( vertexbuffer );
		//GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexbuffer[0]);
		//GL15.glBufferData(vertexbuffer[0], vertices, GL15.GL_STATIC_DRAW);
		
	}

	private void renderStrip(int y) {
		//GL20.glEnableVertexAttribArray(0);
		//GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexbuffer[0]);
		//GL20.glVertexAttribPointer(
		//   0,                  // attribute 0. No particular reason for 0, but must match the layout in the shader.
		//  3,                  // size
		//   GL11.GL_FLOAT,           // type
		//   false,           // normalized?
		//   0,                  // stride
		//   0            // array buffer offset
		//);
		// Draw the triangle !
		//GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3); // Starting from vertex 0; 3 vertices total -> 1 triangle
		//GL20.glDisableVertexAttribArray(0);
		
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2i(100, 100);
		GL11.glVertex2i(200, 100);
		GL11.glVertex2i(200, 200);
		GL11.glVertex2i(100, 200);
		
		GL11.glEnd();
	}
	
	public void render() {
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		renderStrip(100);
		GLFW.glfwSwapBuffers(window);
		GLFW.glfwPollEvents();
		//renderStrip(200);
	}

}
