package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import util.Angle;

public class AngleTest {
	private static final int TESTS = 10000;
	private static Random rand = new Random();
	
	@Test
	public void getterTest() {
		for (int i = 0; i < TESTS; i++) {
			double value = rand.nextDouble() * rand.nextInt();
			Angle angle = new Angle(value);
			double truevalue = value % 360;
			if (truevalue < 0) truevalue += 360;
			assertEquals(truevalue, angle.getAngle(), 0.00001);
			assertTrue(angle.getAngle() >= 0 && angle.getAngle() < 360);
		}
	}
	
	@Test
	public void addtest() {
		for (int i = 0; i < TESTS; i++) {
			double v1 = rand.nextDouble() * rand.nextInt();
			double v2 = rand.nextDouble() * rand.nextInt();
			Angle a1 = new Angle(v1);
			Angle a2 = new Angle(v2);
			double trueValue = (v1 + v2) % 360;
			if (trueValue < 0) trueValue += 360;
			assertEquals(trueValue, a1.add(a2).getAngle(), 0.000001);
		}
	}
}
