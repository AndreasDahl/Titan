package logic.entity.unit;

import logic.Room;
import logic.entity.Unit;
import util.Point;
import util.Vector;
import controller.InputHandler;
import gfx.Art;
import gfx.GameWindow;
import gfx.Screen;

public class Hero extends Unit {

	public Hero(Room room) {
		super(room);
		setCollisionRadius(8);
	}
	
	public void moveTo(Point point) {
//		int x = point.getX();
//		int y = point.getX();
//		
//		if (x < 0)
//			setX(0);
//		else if (x > GameWindow.getInstance().getHeight())
//			setX(GameWindow.getInstance().getHeight()-16);
//		else
//			setX(x);
//		
//		if (y < 0)
//			setX(0);
//		else if (y > GameWindow.getInstance().getHeight())
//			setY(GameWindow.getInstance().getHeight()-16);
//		else
//			setY(y);
	}
	
	@Override
	public void tick(InputHandler input) {
		super.tick(input);
		
		while (GameWindow.w.next());
		if (GameWindow.w.isPressed())
			this.accelerate(new Vector(0,1));
		while (GameWindow.a.next());
		if (GameWindow.a.isPressed())
			this.accelerate(new Vector(-1, 0));
		while (GameWindow.s.next());
		if (GameWindow.s.isPressed())
			this.accelerate(new Vector(0, -1));
		while (GameWindow.d.next());
		if (GameWindow.d.isPressed())
			this.accelerate(new Vector(1, 0));
	}
	
	@Override
	public void render(Screen screen) {
		screen.renderWidthInvisColor((int)this.getX(), (int)this.getY(), Art.HERO, 0xffffffff);
	}
}
