package logic.entity;

import gfx.Screen;
import controller.InputHandler;
import util.Point;

public abstract class Entity {
	private Point position;
	
	public Entity() {
		position = new Point(0,0);
	}
	
	public int getX() {
		return position.getX();
	}
	
	public int getY() {
		return position.getY();
	}
	
	public void setX(int x) {
		this.position.setX(x);
	}
	
	public void setY(int y) {
		this.position.setY(y);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void tick(InputHandler input) {}
	
	public void render(Screen screen) {}
}
