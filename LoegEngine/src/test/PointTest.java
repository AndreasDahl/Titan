package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import util.Angle;
import util.Point;

public class PointTest {
	private Random rand = new Random();
	private static final int TESTS = 10000;

	@Test
	public void getTest() {
		for (int i = 0; i < TESTS; i++) {
			int x = rand.nextInt();
			int y = rand.nextInt();
			Point p = new Point(x, y);
			assertEquals(x, p.getX());
			assertEquals(y, p.getY());
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
			p1 = p1.translate(p2);
			assertEquals(x1 + x2, p1.getX());
			assertEquals(y1 + y2, p1.getY());
			p1 = new Point(x1, y1);
			p1 = p1.translate(x2, y2);
			assertEquals(x1 + x2, p1.getX());
			assertEquals(y1 + y2, p1.getY());
		}
	}

	@Test
	public void distanceTest() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(-3, -4);
		assertEquals(5, (int)p1.distance(p2));
		assertEquals(5, (int)p2.distance(p1));
		assertEquals(5, (int)p1.distance(p3));
		assertEquals(5, (int)p3.distance(p1));
		
		//same both ways
		for (int i = 0; i < TESTS; i++) {
			p1 = new Point(rand.nextInt(), rand.nextInt());
			p2 = new Point(rand.nextInt(), rand.nextInt());
			assertEquals(p1.distance(p2), p2.distance(p1), 0.00001);
		}
	}

	@Test
	public void angleBetweenPointsTest() {
		Point p1 = new Point(0,0);
		assertEquals(new Angle(315.0), p1.angleBetween(new Point(5,5)));
		assertEquals(new Angle(135.0), new Point(5,5).angleBetween(p1));
		
		// test opposite
		for (int i = 0; i < TESTS; i++) {
			p1 = new Point(rand.nextInt(), rand.nextInt());
			Point p2 = new Point(rand.nextInt(), rand.nextInt());
			Angle angle = p1.angleBetween(p2);
			assertEquals(angle.add(new Angle(180)), p2.angleBetween(p1));
		}
	}
}
