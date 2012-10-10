package util.shape;

import java.util.Iterator;

import util.Point;

public abstract class Shape {
	private int width, height;
	private Point position;
	private boolean[] fill;
	
	public Shape(int width, int height, Point position) {
		this.width = width;
		this.height = height;
		this.position = position;
		this.fill = new boolean[width + height * width];
	}
	
	public Point getCenter() {
		return new Point(position.getX() - (width / 2), position.getY() - (height / 2));
	}
	
	public boolean isIn(Point point) {
		return isIn(point.getX(), point.getY());
	}
	
	public boolean isIn(double x, double y) {
		return false;
	}
	
	public void translate(int x, int y) {
		position.translate(x, y);
	}
	
	public boolean inBound(int x, int y) {
		return (x >= position.getX() && x <= position.getX() + width
				|| y >= position.getY() && y <= position.getY() + height);
	}
	
	boolean[] getFill() {
		return fill;
	}
}
