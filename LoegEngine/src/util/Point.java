package util;

public class Point {
	private double x, y;
	
	public static final Point OREGO = new Point(0,0);
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}

	public Point translate(double xt, double yt) {
		return new Point(x + xt, y + yt);
	}
	
	public Point translate(Point otherPoint) {
		return translate(otherPoint.x, otherPoint.y);
	}
	
	public Point translate(Vector vector) {
		return translate(vector.getX(), vector.getY());
	}

	public double distance(Point otherPoint) {
		double dist = Math.sqrt(Math.pow((this.x - otherPoint.x), 2) + Math.pow((this.y - otherPoint.y), 2));
		if (dist == Double.NaN)
			dist = 0;
		return dist;
	}
	
	public Point translateAngle(Angle angle, double distance) {
		return new Point(x + distance * Math.cos(Math.toRadians(angle.getAngle())),
				y + distance * Math.sin(Math.toRadians(angle.getAngle())));
	}
	
	public Angle angleBetween(Point other) {
		double angle = Math.toDegrees(Math.atan2(other.y - y, other.x - x));
		
		return new Angle(angle);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
}
