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

	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}

	public Location round() {
		return new Location((int) x, (int) y);
	}
	
	public Location plus(Location other) {
		return new Location(other.getX() + x, other.getY() + y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass()) {
			if (((Location) obj).getX() == this.x && ((Location) obj).getY() == this.y) {
				return true;
			} else {
				return false;
			}
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return 0;
		//return super.hashCode();
	}

}
