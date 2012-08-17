package logic.entity;

import util.Point;
import gfx.Art;
import gfx.Screen;

public class Mob extends Unit {
	public Mob() {
		super(1);
	}
	
	private void moveTorwards(Point point) {
		
	}
	
	@Override
	public void render(Screen screen) {
		super.render(screen);
		
		screen.render(this.getX(), this.getY(), Art.ORC);
	}
}
