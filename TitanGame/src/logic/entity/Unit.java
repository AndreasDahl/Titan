package logic.entity;

import controller.InputHandler;
import util.Point;
import util.Vector;
import logic.Entity;
import logic.Room;

public abstract class Unit extends Collidable {
	private int hp_max, hp;
	private Vector speed;
	
	public Unit(Room room) {
		super(room);
		speed = new Vector(0,0);
	}
	
	public Vector getSpeed() {
		return speed;
	}
	
	public void accelerate(Vector vector) {
		speed = speed.add(vector);
	}
	
	@Override
	public void tick(InputHandler input) {
		super.tick(input);
		
		
		speed = speed.scale(0.75);
		tryMove();
	}
	
	public void tryMove() {
		this.speed = this.getRoom().collide(this);
		this.setPosition(getPosition().translate(speed));
	}
}
