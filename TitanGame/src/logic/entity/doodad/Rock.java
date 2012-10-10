package logic.entity.doodad;

import logic.Room;
import logic.entity.Doodad;
import gfx.Art;
import gfx.Screen;

public class Rock extends Doodad {
	
	public Rock(Room room) {
		super(room);
		this.setCollisionRadius(8);
	}
	
	@Override
	public void render(Screen screen) {
		screen.render((int)this.getX(), (int)this.getY(), Art.ROCK);
	}
}
