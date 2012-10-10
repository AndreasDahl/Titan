package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import util.Angle;
import util.Point;

public class PointTest {
	private Random rand = new Random();
	private static final int TESTS = 10000;
	private static final double PRECISION = 0.0001;

	@Test
	public void getTest() {
		for (int i = 0; i < TESTS; i++) {
			double x = rand.nextInt();
			double y = rand.nextInt();
			Point p = new Point(x, y);
			assertEquals(x, p.getX(), PRECISION);
			assertEquals(y, p.getY(), PRECISION);
		}
	}
	
	@Test
	public void translateTest() {
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			double x2 = rand.nextInt();
			double y2 = rand.nextInt();
			Point p1 = new Point(x1, y1);
			Point p2 = new Point(x2, y2);
			p1 = p1.translate(p2);
			assertEquals(x1 + x2, p1.getX(), PRECISION);
			assertEquals(y1 + y2, p1.getY(), PRECISION);
			p1 = new Point(x1, y1);
			p1 = p1.translate(x2, y2);
			assertEquals(x1 + x2, p1.getX(), PRECISION);
			assertEquals(y1 + y2, p1.getY(), PRECISION);
		}
	}

	@Test
	public void distanceTest() {
		Point p1 = new Point(0,0);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(-3, -4);
		assertEquals(5, p1.distance(p2), PRECISION);
		assertEquals(5, p2.distance(p1), PRECISION);
		assertEquals(5, p1.distance(p3), PRECISION);
		assertEquals(5, p3.distance(p1), PRECISION);
		
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
		Point p2 = new Point(8,5);
		Point p3 = new Point(7.5, 7);
		assertEquals(new Angle(45.0), p1.angleBetween(new Point(5,5)));
		assertEquals(new Angle(225.0), new Point(5,5).angleBetween(p1));		
		
		// test opposite
		for (int i = 0; i < TESTS; i++) {
			p1 = new Point(rand.nextInt(), rand.nextInt());
			Point pt = new Point(rand.nextInt(), rand.nextInt());
			Angle angle = p1.angleBetween(pt);
			assertEquals(angle.add(new Angle(180)), pt.angleBetween(p1));
		}
	}
	
	@Test
	public void translateAngleTest() {
		for (int i = 0; i < TESTS; i++) {
			double x = rand.nextInt(10);
			double y = rand.nextInt(10);
			double dist = Math.abs(rand.nextInt(10)+1);
			Angle angle = new Angle(rand.nextInt(400));
			Point p = new Point(x,y);
			Point p2 = p.translateAngle(angle, dist);
			
			assertEquals(dist, p.distance(p2), 0.0001);
			assertEquals(angle, p.angleBetween(p2));
			

		}
	}
}
