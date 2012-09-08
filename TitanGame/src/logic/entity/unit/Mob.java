package logic.entity.unit;

import logic.Room;
import logic.entity.Unit;
import util.Point;
import gfx.Art;
import gfx.Screen;

public class Mob extends Unit {
	public Mob(Room room) {
		super(room);
	}
	
	private void moveTorwards(Point point) {
		
	}
	
	@Override
	public void render(Screen screen) {
		screen.render(this.getX(), this.getY(), Art.ORC);
	}
}
