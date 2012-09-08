package logic.entity;

import util.Point;
import logic.Entity;
import logic.Room;

public abstract class Unit extends Collidable {
	private int hp_max, hp;
	private double speed;
	
	public Unit(Room room) {
		super(room);
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void tryMove(Point point) {
		Point oldPosition = this.getPosition();
		this.setPosition(point);
		if (this.getRoom().collide(this)) {
			this.setPosition(oldPosition);
		}
	}
}
