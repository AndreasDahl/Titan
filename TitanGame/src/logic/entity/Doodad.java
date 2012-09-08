package logic.entity;

import logic.Entity;
import logic.Room;

public abstract class Doodad extends Collidable {
	private boolean collide;
	
	public Doodad(Room room) {
		super(room);
	}
	
	public boolean isWalkable() {
		return collide;
	}
	
	public void setWalkable(boolean walkable) {
		this.collide = walkable;
	}
}
