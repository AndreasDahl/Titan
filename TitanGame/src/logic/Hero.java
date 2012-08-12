package logic;

import gfx.GameWindow;

public class Hero extends Entity {
	public void move(int x, int y) {
		if (x < 0)
			setX(0);
		else if (x > GameWindow.getInstance().getHeight())
			setX(GameWindow.getInstance().getHeight());
		else
			setX(GameWindow.getInstance().getHeight());
		
		if (y < 0)
			setX(0);
		else if (y > GameWindow.getInstance().getHeight())
			setY(GameWindow.getInstance().getHeight());
		else
			setY(GameWindow.getInstance().getHeight());
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (GameWindow.w.isDown) {
			
		}
	}
}
