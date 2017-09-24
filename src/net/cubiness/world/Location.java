package net.cubiness.world;

public class Location {
	
	private float x;
	private float y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Location(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
