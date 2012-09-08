package util;

public class Vector {
	private int x, y;
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public double length() {
		return Point.OREGO.distance(new Point(x, y));
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null && arg0 instanceof Vector) {
			Vector other = (Vector)arg0;
			return (this.x == other.x
					&& this.y == other.y);
		}
		return false;
	}
	
	public Vector add(Vector otherVector) {
		return new Vector(x + otherVector.x, y + otherVector.y);
	}
	
	public Vector subtract(Vector otherVector) {
		return new Vector(x - otherVector.x, y - otherVector.y);
	}
	
	public Vector scale(double scale) {
		return new Vector((int)(x * scale), (int)(y * scale));
	}
	
	public int dot(Vector otherVector) {
		return x * otherVector.x + y * otherVector.y;
	}
	
	public Angle angle() {
		return Point.OREGO.angleBetween(new Point(this.x, this.y));
	}
	
	
}
