package gfx;

public class Screen {
	private int[] pixels;	
	private final int width;
	
	public Screen(int[] pixels, int width) {
		this.width = width;
		this.pixels = pixels;
	}

	private int applyTransparency(int color, int bgColor) {
		int t = (color >> 24) & 0xff;
		int nred = ((color & 0xff0000) * t >> 8) & 0xff0000;
		int ngreen = ((color & 0xff00) * t >> 8) & 0xff00;
		int nblue = ((color & 0xff) * t >> 8) & 0xff;
		
		int t2 = 0xff - t;
		int ored = ((bgColor & 0xff0000) * t2 >> 8) & 0xff0000;
		int ogreen = ((bgColor & 0xff00) * t2 >> 8) & 0xff00; 
		int oblue = ((bgColor & 0xff) * t2 >> 8) & 0xff;			
		
		int red = nred + ored;
		int green = ngreen + ogreen; 
		int blue = nblue + oblue;
		
		return red | green | blue;
	}
	
	private void paintPixelHue(int position, int color, double hue, double saturation) {
		if (isValidPixel(position)) {
			int trans = ((color >> 24) & 0xff);
			if (trans == 0);
			else if (trans == 0xff) {
				color = Color.applyHue(color, hue, saturation);
				pixels[position] = color;
			}
			else {
				color = Color.applyHue(color, hue, saturation);
				pixels[position] = applyTransparency(color, pixels[position]);
			}
		}
	}
	
	private boolean isValidPixel(int pixel) {
		if (pixel > 0 && pixel < pixels.length)
			return true;
		return false;
	}
	
	private void paintPixel(int position, int color) {
		if (isValidPixel(position)) {
			int trans = ((color >> 24) & 0xff);
			if (trans == 0);
			else if (trans == 0xff)
				pixels[position] = color;
			else {
				pixels[position] = applyTransparency(color, pixels[position]);
			}
		}
	}
	
	/**
	 * <p>Renders a sprite on the screen with the sprite's original size.</p>
	 * 
	 * <p>the position given will be the position of the sprite's upper left
	 * corner
	 * @param xp  x-position to be rendered at
	 * @param yp  y-position to be rendered at
	 * @param sprite
	 */
	public void render(int xp, int yp, Sprite sprite) {
		int w = sprite.getWidth();
		int h = sprite.getHeight();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				paintPixel((x + xp) + (y+yp) * width, sprite.getPixel(x, y));
			}
		}
	}
	
	/**
	 * Renders a square with the given size at the given position
	 * @param xp	x-position
	 * @param yp	y-position
	 * @param w		width of the square
	 * @param h		Height of the square 
	 * @param color Color of the square
	 */
	public void renderSquare(int xp, int yp, int w, int h, int color) {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				paintPixel((x+xp) + (y+yp) * width, color);
			}
		}
	}
	
	/**
	 * <p>Scales a sprite to the given size and renders it on the screen
	 * @param xp		x-position
	 * @param yp		y-position
	 * @param height	height to scale to
	 * @param width		width to scale to
	 * @param sprite	the sprite
	 */
	public void render(int xp, int yp, int height, int width, Sprite sprite) {
		int sw = sprite.getWidth();
		int sh = sprite.getHeight();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				paintPixel((x + xp) + (y+yp) * this.width, sprite.getPixel(x*sw/width, y*sh/height));
			}
		}
	}
	
	/**
	 * <p>Renders a sprite on the screen with an applied hue</p>
	 * <p><b>WARNING:</b> Pretty slow</p> 
	 * @param xp		x-position
	 * @param yp		y-position
	 * @param sprite	sprite
	 * @param hueColor		color of the hue. Remember transparency data!
	 */
	public void renderHue(int xp, int yp, Sprite sprite, int hueColor) {
		int w = sprite.getWidth();
		int h = sprite.getHeight();
		
		double hue = Color.getHue(hueColor);
		double saturation = (hueColor >> 24 & 0xff) / 255.0;
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int c = sprite.getPixel(x, y);
				int pos = (x + xp) + (y+yp) * width;
				
				paintPixelHue(pos, c, hue, saturation);
			}
		}
	}
	
	/**
	 * <p>Renders a sprite per usual, but will treat any pixels with the
	 * given color as if it had 100% transparency
	 * @param xp		x-position
	 * @param yp		y-position
	 * @param sprite	sprite
	 * @param color		invisible color
	 */
	public void renderWidthInvisColor(int xp, int yp, Sprite sprite, int color) {
		int w = sprite.getWidth();
		int h = sprite.getHeight();
		for (int y = 0; y < w; y++) {
			for (int x = 0; x < h; x++) {
				int col = sprite.getPixel(x + y * w) & 0xffffff;
				if (color != col)
					pixels[(x + xp) + (y+yp) * width] = col;
			}
		}
	}
	
}
