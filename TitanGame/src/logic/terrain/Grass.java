package logic.terrain;

import java.util.Random;

import logic.entity.Doodad;

import gfx.Art;
import gfx.Screen;
import gfx.Sprite;

public class Grass extends Terrain {
	
	@Override
	public void render(Screen screen) {
	}
	
	@Override
	public Sprite getSprite() {
		return Art.GRASS;
	}

}
