package util.shape;

import util.Point;

public class Square extends Shape {	
	public Square(int x, int y, int width, int height) {
		super(width, height, new Point(x, y));
		boolean[] fill = getFill();
		for (int i = 0; i < fill.length; i++) {
			fill[i] = true;
		}
	}
	
	
}
