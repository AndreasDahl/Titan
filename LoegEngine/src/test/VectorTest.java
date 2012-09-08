package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import util.Vector;

public class VectorTest {
	private static final int TESTS = 10000;
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
			int x1 = rand.nextInt();
			int y1 = rand.nextInt();
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
			Vector v1 = new Vector(x1, y1);
			Vector v2 = new Vector(x2, y2);
			Vector res = new Vector(x1 + x2, y1 + y2);
			assertEquals(res, v1.add(v2));
		}
	}
	
	@Test
	public void subtractTest() {
		for (int i = 0; i < TESTS; i++) {
			int x1 = rand.nextInt();
			int y1 = rand.nextInt();
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
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
			int x = rand.nextInt();
			int y = rand.nextInt();
			assertTrue(new Vector(x, y).equals(new Vector(x, y)));
		}
		
		//falseTests
		for (int i = 0; i < TESTS; i++) {
			int x1 = rand.nextInt();
			int y1 = rand.nextInt();
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
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
			int x = rand.nextInt(1000);
			int y = rand.nextInt(1000);
			int newX = (int)(x * s);
			int newY = (int)(y * s);
			assertEquals(new Vector(newX, newY), new Vector(x, y).scale(s));
		}
	}
	
	@Test
	public void dotProductTest() {
		for (int i = 0; i < TESTS; i++) {
			int x1 = rand.nextInt();
			int y1 = rand.nextInt();
			int x2 = rand.nextInt();
			int y2 = rand.nextInt();
			int dot = x1 * x2 + y1 * y2;
			assertEquals(dot, new Vector(x1, y1).dot(new Vector(x2, y2)));
		}
	}

}
