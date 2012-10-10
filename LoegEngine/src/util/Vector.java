package util;

public class Vector {
	private double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double length() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
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
		return new Vector((x * scale), (y * scale));
	}
	
	public double dot(Vector otherVector) {
		return x * otherVector.x + y * otherVector.y;
	}
	
	public Angle angle() {
		double angle = Math.toDegrees(Math.atan(this.y / this.x));
		if (y >= 0) angle += 90;
		else angle -= 90;
		return new Angle(angle);
	}
	
	@Override
	public String toString() {
		return "Vector: (" + x + ", " + y + ")";
	}
}
