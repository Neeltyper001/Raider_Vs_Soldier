package Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.audios.GameStartEffect;
import com.constants.GameConstants;
import com.constants.GameResourcesPath;
import com.constants.TemporalConstants;

public class SplashScreen extends JWindow implements GameResourcesPath,GameConstants,TemporalConstants{
	private JLabel label = new JLabel();
	private GameStartEffect gameStartEffect = new GameStartEffect();
	
	public SplashScreen() {
		setSize(SPLASH_SCREEN_WIDTH,SPLASH_SCREEN_HEIGHT);
		Icon icon = new ImageIcon(SplashScreen.class.getResource(SPLASH_SCREEN));
		label.setIcon(icon);
		this.add(label);
		setLocationRelativeTo(null);
		setVisible(true);
		gameStartEffect.playGameStart();
		try {
			Thread.sleep(FIVE_SECONDS);
			setVisible(false);
			dispose();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
