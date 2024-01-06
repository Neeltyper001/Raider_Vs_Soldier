package Graphics;

import java.awt.Color;

public class EnemyVisuals {
	private Color emptyHealthBar;
	private Color currentHealthBar;

	
	public EnemyVisuals(){
		this.emptyHealthBar = new Color(255,0,0);
		this.currentHealthBar = new Color(0,255,0);
	}

	public Color getEmptyHealthBar() {
		return emptyHealthBar;
	}

	public void setEmptyHealthBar(Color emptyHealthBar) {
		this.emptyHealthBar = emptyHealthBar;
	}

	public Color getCurrentHealthBar() {
		return currentHealthBar;
	}

	public void setCurrentHealthBar(Color currentHealthBar) {
		this.currentHealthBar = currentHealthBar;
	}
	
	
}
