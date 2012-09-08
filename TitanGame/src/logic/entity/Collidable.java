package logic.entity;

import gfx.Screen;
import logic.Entity;
import logic.Room;
import util.Point;

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
	
	public boolean collide(Collidable collidable) {
		return getPosition().distance(collidable.getPosition()) < collisionRadius + collidable.collisionRadius;
	}
	
}
