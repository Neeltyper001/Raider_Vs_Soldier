package Graphics;

import java.awt.image.BufferedImage;

import com.sprites.Sprites;

public class LoadBackground {
	
	private Sprites backgroundSprite;
	
	public LoadBackground(String resource) {
		backgroundSprite = new Sprites(resource);
	}
	
	public BufferedImage getBackground() {
		return this.backgroundSprite.getImage();
	}
}
