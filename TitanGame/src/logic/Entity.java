package logic;

import gfx.Renderable;
import gfx.Screen;
import controller.InputHandler;
import util.Point;

public abstract class Entity implements Renderable {
	private Point position;
	private Room room;
	
	public Entity(Room room) {
		this.room = room;
		position = new Point(0,0);
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public void setX(int x) {
		position = new Point(x, getY());
	}
	
	public void setY(int y) {
		position = new Point(getX(), y);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void tick(InputHandler input) {}
}
