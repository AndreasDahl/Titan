package main;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import controller.InputHandler;
import gfx.GameComponent;
import gfx.GamePanel;
import gfx.Screen;
import gfx.Sprite;

public class Game extends GameComponent {
	private int[][] grid;
	private Sprite sprite;
	private Hero hero;
	
	public Game() {
		Random gridrand = new Random();
		grid = new int[20][20];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = gridrand.nextInt(3)*100 | 0xff000000;
			}
		}
		
		hero = new Hero();
		
		try {
			File file = new File("res\\Hero.png");
			System.out.println(file.getAbsolutePath());
			
			sprite = new Sprite(ImageIO.read(new File("res\\Hero.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void tick(InputHandler input) {
		super.tick(input);
		
		
	}
	
	@Override
	public void render(Screen screen) {
		GamePanel gp = GamePanel.getInstance();
		screen.renderSquare(0, 0, gp.getWidth(), gp.getHeight(), 0xff00ff00);
		screen.render(hero.getX()*16, hero.getY()*16, sprite);
		
	}
}
