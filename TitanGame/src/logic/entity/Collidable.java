package logic.entity;

import logic.Entity;
import logic.Room;
import util.Angle;
import util.Point;
import util.Vector;

public abstract class Collidable extends Entity {
	private double collisionRadius = 0;
	
	public Collidable(Room room) {
		super(room);
	}
	
	public double getCollisionRadius() {
		return collisionRadius;
	}

	public void setCollisionRadius(double collision_radius) {
		this.collisionRadius = collision_radius;
	}

	public boolean collide(Point point) {
		return getPosition().distance(point) < collisionRadius;
	}
	
	public Vector collide(Collidable collidable, Vector speed) {
		Angle angle = this.getPosition().angleBetween(collidable.getPosition());
		Vector directionV;
		Angle newAngle;
		if (speed.angle().add(angle).add(new Angle(180)).getAngle() > 180) {
			newAngle = angle.add(new Angle(90));
		}
		else {
			newAngle = angle.add(new Angle(-90));
		}
		directionV = new Vector(newAngle, 1);
		double newSpeed = speed.dot(directionV);
		return new Vector(newAngle, newSpeed);
	}
	
}
