package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import util.Point;

public class PointTest {
	private Random rand = new Random();
	private static final int TESTS = 1000;

	@Test
	public void setGetTest() {
		for (int i = 0; i < TESTS; i++) {
			int x = rand.nextInt();
			int y = rand.nextInt();
			Point p = new Point(x, y);
			assertEquals(x, p.getX());
			assertEquals(y, p.getY());
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
			p.setX(x2);
			p.setY(y2);
			assertEquals(x2, p.getX());
			assertEquals(y2, p.getY());
		}
	}
	
	@Test
	public void translateTest() {
		for (int i = 0; i < TESTS; i++) {
			int x1 = rand.nextInt();
			int y1 = rand.nextInt();
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
			Point p1 = new Point(x1, y1);
			Point p2 = new Point(x2, y2);
			p1.translate(p2);
			assertEquals(x1 + x2, p1.getX());
			assertEquals(y1 + y2, p1.getY());
			p1 = new Point(x1, y1);
			p1.translate(x2, y2);
			assertEquals(x1 + x2, p1.getX());
			assertEquals(y1 + y2, p1.getY());
		}
	}

}
