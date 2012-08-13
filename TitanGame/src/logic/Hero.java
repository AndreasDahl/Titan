package logic;

import util.Point;
import controller.InputHandler;
import gfx.GameWindow;

public class Hero extends Entity {
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
		Point relativePoint = new Point(0,0);
		
		while (GameWindow.w.next());
		if (GameWindow.w.isPressed())
			relativePoint.translate(0, -2);
		while (GameWindow.a.next());
		if (GameWindow.a.isPressed())
			relativePoint.translate(-2, 0);
		while (GameWindow.s.next());
		if (GameWindow.s.isPressed())
			relativePoint.translate(0, 2);
		while (GameWindow.d.next());
		if (GameWindow.d.isPressed())
			relativePoint.translate(2, 0);
		moveTo(getPosition().translate(relativePoint));
	}
}
