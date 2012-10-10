package gfx;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import controller.InputHandler;

public class GamePanel extends Canvas implements Runnable {
	private static final long serialVersionUID = 5761980091712249788L;
	
	private static GamePanel instance;
	
	private int screenWidth;
	private int screenHeight;
	
	private int ticksPerSecond;
	private int fps;
	
	private double nsPerTick;
	private boolean running;
	
	private BufferedImage image;
	private int[] pixels;
	private Screen screen;
	private int pixelScale = 1;
	
	private InputHandler gameControl;
	private GameComponent activeComponent;
	
	public GamePanel(int width, int height) {
		this(width, height, 1);
	}
	
	public GamePanel(int width, int height, int pixelScale) {
		this.screenWidth = width;
		this.screenHeight = height;
		this.pixelScale = pixelScale;
		this.setPreferredSize(new Dimension(width * pixelScale, height * pixelScale));
		setTicksPerSecond(60);
		
		instance = this;
	}
	
	public static GamePanel getInstance() {
		return instance;
	}
	
	public void setComponent(GameComponent component) {
		activeComponent = component;
	}
	
	public void setTicksPerSecond(int ticks) {
		nsPerTick = 1000000000.0 / ticks;
	}
	
	public InputHandler getInputHandler() {
		return gameControl;
	}
	
	public void setInputHandler(InputHandler input) {
		gameControl = input;
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
	
	private void prepareScreen(int width, int height) {
		image = new BufferedImage(screenWidth, screenHeight, BufferedImage. TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		screen = new Screen(pixels, screenWidth);
	}
			
	private void init() {
		prepareScreen(this.screenWidth, this.screenHeight);
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();

		double unprocessed = 0;
		int ticks = 0;
		int frames = 0;
		long lastTimer1 = System.currentTimeMillis();
		
		init();
		
		while (running) {
			long now = System.nanoTime();

			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			if (unprocessed >= 1) {
				tick();
				ticks++;
				unprocessed -= 1;
				shouldRender = true;
			}
			
			/*try {
				Thread.sleep(0,2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			
			if (shouldRender) {
				frames++;
				render();
			}
			
			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				fps = frames;
				ticksPerSecond = ticks;
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick() {
		if (activeComponent != null)
			activeComponent.tick(gameControl);
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			requestFocus();
			return;
		}
		
		if (activeComponent != null)
			activeComponent.render(screen);
			
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public long getTime() {
		return System.nanoTime();
	}
	
	public int getFPS() {
		return fps;
	}
	
	public int getTicksPerSecond() {
		return ticksPerSecond;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	
}
