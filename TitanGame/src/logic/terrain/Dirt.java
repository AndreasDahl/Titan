package logic.terrain;

import gfx.Art;
import gfx.Screen;
import gfx.Sprite;

public class Dirt extends Terrain {

	@Override
	public void render(Screen screen) {
	}
	
	@Override
	public Sprite getSprite() {
		return Art.GRASS;
	}

}
