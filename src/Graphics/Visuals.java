package Graphics;

import java.awt.Color;
import java.awt.Font;

public class Visuals {
	private Color emptyHealthBar;
	private Color currentHealthBar;
	private Color emptyBaseLifeBar;
	private Color currentBaseLifeBar;
	private Color fontColor;
	private Font font;
	
	public Visuals() {
		this.emptyHealthBar = new Color(255,0,0);
		this.currentHealthBar = new Color(0,255,0);
		this.emptyBaseLifeBar = new Color(255,0,0);
		this.currentBaseLifeBar = new Color(0,255,0);
		this.fontColor = new Color(255,255,255);
		this.font = new Font ("ARIAL", Font.BOLD, 23);
	}

	public Color getEmptyHealthBar() {
		return emptyHealthBar;
	}

	public Color getCurrentHealthBar() {
		return currentHealthBar;
	}


	public Color getEmptyBaseLifeBar() {
		return emptyBaseLifeBar;
	}

	public Color getCurrentBaseLifeBar() {
		return currentBaseLifeBar;
	}

	public Color getFontColor() {
		return fontColor;
	}
	
	public Font getFont() {
		return font;
	}
	
	
	
}
