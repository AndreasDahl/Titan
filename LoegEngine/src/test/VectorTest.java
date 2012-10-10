package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import util.Angle;
import util.Vector;

public class VectorTest {
	private static final int TESTS = 10000;
	private static final double PRECISION = 0.001;
	private static Random rand;
	
	private Vector[] vectors;
	
	@Before
	public void setUp() {
		rand = new Random();
		vectors = new Vector[TESTS];
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Vector(rand.nextInt(), rand.nextInt());
		}
	}

	@Test
	public void addTest() {
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			double x2 = rand.nextInt();
			double y2 = rand.nextInt();
			Vector v1 = new Vector(x1, y1);
			Vector v2 = new Vector(x2, y2);
			Vector res = new Vector(x1 + x2, y1 + y2);
			assertEquals(res, v1.add(v2));
		}
	}
	
	@Test
	public void subtractTest() {
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			double x2 = rand.nextInt();
			double y2 = rand.nextInt();
			Vector v1 = new Vector(x1, y1);
			Vector v2 = new Vector(x2, y2);
			Vector res = new Vector(x1 - x2, y1 - y2);
			assertEquals(res, v1.subtract(v2));
		}
	}
	
	@Test
	public void equalsTest() {
		//trueTests
		for (int i = 0; i < TESTS; i++) {
			double x = rand.nextInt();
			double y = rand.nextInt();
			assertTrue(new Vector(x, y).equals(new Vector(x, y)));
		}
		
		//falseTests
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			double x2 = rand.nextInt();
			double y2 = rand.nextInt();
			Vector v1 = new Vector(x1, y1);
			Vector v2 = new Vector(x2, y2);
			if (x1 == x2 && y1 == y2)
				assertTrue(v1.equals(v2));
			else
				assertFalse(v1.equals(v2));
		}
	}
	
	@Test
	public void scaleTest() {
		for (int i = 0; i < TESTS; i++) {
			double s = rand.nextDouble() * rand.nextInt(1000);
			double x = rand.nextInt(1000);
			double y = rand.nextInt(1000);
			double newX = (x * s);
			double newY = (y * s);
			assertEquals(new Vector(newX, newY), new Vector(x, y).scale(s));
		}
	}
	
	@Test
	public void dotProductTest() {
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			double x2 = rand.nextInt();
			double y2 = rand.nextInt();
			double dot = x1 * x2 + y1 * y2;
			assertEquals(dot, new Vector(x1, y1).dot(new Vector(x2, y2)), PRECISION);
		}
	}
	
	@Test
	public void angleTest() {
		for (int i = 0; i < TESTS; i++) {
			double x1 = rand.nextInt();
			double y1 = rand.nextInt();
			Vector v1 = new Vector(x1, y1);
			Vector v2 = new Vector(-x1, -y1);
			assertEquals(v1.angle(), v2.angle().add(new Angle(180.0)));
		}
	}

}
