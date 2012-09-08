package util;

public class Angle {
	private static final double EQUALS_PRECISION = 0.0000001;
	private double angle;
	
	public Angle(double angle) {
		setAngle(angle);
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null && arg0 instanceof Angle) {
			Angle other = (Angle)arg0;
			return (this.angle <= other.angle+EQUALS_PRECISION
					&& this.angle >= other.angle-EQUALS_PRECISION);
		}
		return false;
	}
	
	private void setAngle(double angle) {
		this.angle = angle % 360.0;
		if (this.angle < 0)
			this.angle += 360.0;
	}
	
	public Angle add(Angle angle) {
		return new Angle(this.angle + angle.angle);
	}
	
	public double getAngle() {
		return this.angle;
	}
}
