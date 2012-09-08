package util;

public class Point {
	private int x, y;
	
	public static final Point OREGO = new Point(0,0);
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	public Point translate(int xt, int yt) {
		return new Point(x + xt, y + yt);
	}
	
	public Point translate(Point otherPoint) {
		return translate(otherPoint.x, otherPoint.y);
	}

	public double distance(Point otherPoint) {
		return Math.sqrt(Math.pow((double)(this.x - otherPoint.x), 2) + Math.pow((double)(this.y - otherPoint.y), 2));
	}
	
	public Point translate(double angle, double distance) {
		return new Point((int)(x + distance / Math.cos(angle)), (int)(y + distance / Math.sin(angle)));
	}
	
	public Angle angleBetween(Point otherPoint) {
		double angle = Math.toDegrees(Math.atan(((double)(this.y - otherPoint.y) / (double)(this.x - otherPoint.x))));
		angle -= 90;
		if (this.y - otherPoint.y >= 0) angle += 180; 
		if (angle < 0) angle += 360;
		if (angle >= 360) angle -= 360;

		return new Angle(angle);
	}
}
