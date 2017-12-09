package net.cubiness.world;

public class Location {
	
	private double x;
	private double y;
	
	public Location(int x, int y) {
	    this.x = x;
		this.y = y;
	}

	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	public Location round() {
		return new Location(Math.round(x), Math.round(y));
	}
	
	public Location plus(Location other) {
		return new Location(other.getX() + x, other.getY() + y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == this.getClass()) {
			return (((Location) obj).getX() == this.x && ((Location) obj).getY() == this.y);
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return 0;
	}

	public Location floor() {
		return new Location(Math.floor(x), Math.floor(y));
	}

    @Override
    public String toString() {
        return "Location [x=" + x + ", y=" + y + "]";
    }

    public Location copy() {
        return new Location(x, y);
    }

}
