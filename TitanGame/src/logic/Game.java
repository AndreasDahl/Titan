package logic;

import java.util.Random;

import logic.entity.Hero;

import controller.InputHandler;
import gfx.GameComponent;
import gfx.GamePanel;
import gfx.GameWindow;
import gfx.Screen;

public class Game extends GameComponent {
	private Terrain[][] grid;
	private Hero hero;
	private static final int TILE_SIZE = 16;
	
	public Game() {
		Random gridrand = new Random();
		grid = new Terrain[GameWindow.getInstance().getScreenWidth() / TILE_SIZE][GameWindow.getInstance().getScreenHeight() / TILE_SIZE];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = new Grass();
			}
		}
		
		hero = new Hero();
		

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
		
	}
}
