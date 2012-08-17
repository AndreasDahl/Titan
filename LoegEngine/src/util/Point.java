package util;

public class Point {
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point translate(int xt, int yt) {
		x += xt;
		y += yt;
		return this;
	}
	
	public Point translate(Point otherPoint) {
		return translate(otherPoint.x, otherPoint.y);
	}

	public double distance(Point otherPoint) {
		return Math.sqrt((this.x - otherPoint.x) ^2 + (this.y - otherPoint.y) ^2);
	}
	
	public Point translate(double angle, double distance) {
		return new Point((int)(x + distance / Math.cos(angle)), (int)(y + distance / Math.sin(angle)));
	}
	
	public double angleBetween(Point otherPoint) {
		return Math.tan((double)(this.y - otherPoint.y) / (double)(this.x - otherPoint.x));
	}
}
