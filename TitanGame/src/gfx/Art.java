package gfx;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Art {
	public static final Sprite HERO = loadSprite("hero.png", 16, 16);
	public static final Sprite ORC = loadSprite("orc.png", 16, 16);
	
	public static final Sprite GRASS = loadSprite("grass.png", 16, 16);
	
	public static final Sprite ROCK = loadSprite("rock.png", 16, 16);
	
	public static Sprite loadSprite(String url, int width, int height) {
		File file = new File("res\\" + url);
		Sprite sprite;
		try {
			sprite = new Sprite(ImageIO.read(new File("res\\" + url)), width, height);
			System.out.println("Loaded: " + file.getAbsolutePath());
		} catch (IOException e) {
			sprite = Sprite.placeholder(width, height);
			System.out.println("Loading failed: " + file.getAbsolutePath());
		}
		return sprite;
	}
}
