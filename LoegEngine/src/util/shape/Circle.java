package util.shape;

import util.Point;

public class Circle extends Shape {
	
	public Circle(int x, int y, int r) {
		super(r * 2, r * 2, new Point(x, y));
	}
	

}
