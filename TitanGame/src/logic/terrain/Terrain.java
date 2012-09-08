package logic.terrain;

import gfx.Renderable;
import gfx.Screen;
import gfx.Sprite;

public abstract class Terrain implements Renderable {
	@Override
	public abstract void render(Screen screen);
	public abstract Sprite getSprite();
}
