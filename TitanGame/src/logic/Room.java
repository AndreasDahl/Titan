package logic;

import java.util.ArrayList;
import java.util.Random;

import util.Point;

import logic.entity.Collidable;
import logic.entity.Doodad;
import logic.entity.doodad.Rock;
import logic.entity.unit.Hero;
import logic.terrain.Grass;
import logic.terrain.Terrain;

import controller.InputHandler;
import gfx.GameComponent;
import gfx.GamePanel;
import gfx.GameWindow;
import gfx.Screen;

public class Room extends GameComponent {
	private Terrain[][] grid;
	private Hero hero;
	private ArrayList<Doodad> doodads;
	private static final int TILE_SIZE = 16;
	
	public Room() {
		doodads = new ArrayList<Doodad>();
		Random gridrand = new Random();
		grid = new Terrain[GameWindow.getInstance().getScreenWidth() / TILE_SIZE][GameWindow.getInstance().getScreenHeight() / TILE_SIZE];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = new Grass();
				if (gridrand.nextInt(10) == 0) {
					Doodad doodad = new Rock(this);
					doodad.setX(i * TILE_SIZE);
					doodad.setY(j * TILE_SIZE);
					doodads.add(doodad);
				}
			}
		}
		
		hero = new Hero(this);
	}
	
	public Terrain getTile(Point point) {
		return grid[(int)point.getX()][(int)point.getY()];
	}
	
	@Override
	public void tick(InputHandler input) {
		super.tick(input);
		
		hero.tick(input);
	}
	
	@Override
	public void render(Screen screen) {
		super.render(screen);
		
		GamePanel gp = GamePanel.getInstance();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				screen.render(i * TILE_SIZE, j * TILE_SIZE, grid[i][j].getSprite());
			}
		}
		
		hero.render(screen);
		
		for (Doodad doodad : doodads) {
			doodad.render(screen);
		}
		GameWindow.frame.setTitle(Integer.toString(GameWindow.getInstance().getFPS()));
	}
	
	public boolean collide(Point point) {
		for (Doodad doodad : doodads) {
			if (doodad.collide(point))
				return true;
		}
		return false;
	}
	
	public boolean collide(Collidable collidable, Point point) {
		for (Doodad doodad : doodads) {
			if (doodad != collidable && doodad.collide(collidable, point))
				return true;
		}
		return false;
	}
}
