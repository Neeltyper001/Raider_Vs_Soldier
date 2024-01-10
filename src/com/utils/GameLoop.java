package com.utils;

import com.audios.GameMusic;
import com.audios.GameOverEffect;
import com.constants.TemporalConstants;
import com.main.GamePanel;

public class GameLoop implements Runnable, TemporalConstants {
	
	private final int FPS_SET = FPS_COUNT;
	private final int UPS_SET = UPS_COUNT; 
	private GamePanel gamePanel;
	private GameMusic gameMusic;
	private GameOverEffect gameOverEffect;
	
	public GameLoop(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		gameMusic = new GameMusic();
		gameOverEffect = new GameOverEffect();
		gameMusic.playGameMusic();
	}

	@Override
	public void run() {
		double nanoTimePerFrame = NANO_PRECISION/this.FPS_SET;
		double nanoTimePerUpdate = NANO_PRECISION/this.UPS_SET;

		long lastCheck = System.currentTimeMillis();
		
		long previousUpdateTime = System.nanoTime();
		int frames = INITIAL_FRAMES;
		int updates = INITIAL_FRAMES;
		
		double deltaU = DELTA_U;
		double deltaF = DELTA_F;
		
		while(true) {
			long currentUpdateTime = System.nanoTime(); 
			
			deltaU += (currentUpdateTime - previousUpdateTime) / nanoTimePerUpdate;
			deltaF += (currentUpdateTime - previousUpdateTime) / nanoTimePerFrame;
			previousUpdateTime = currentUpdateTime;
			if(deltaU >= UNITY) {
//				this.updateGame();
				updates++;
				deltaU--;
			}
			
			if(deltaF >=UNITY) {
				gamePanel.repaint();
				frames++;	
				deltaF--;
			}
			
			
			if(System.currentTimeMillis() - lastCheck >= ONE_SECOND) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS : "+frames+" | UPS : "+updates);
				frames = INITIAL_FRAMES;
				updates = INITIAL_UPDATES;
			}
					
			
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        if(this.gamePanel.getEndGameLoop()) {
	        	gameMusic.stopGameMusic();
	        	gameOverEffect.playGameOver();
	        	break;
	        }
	        	   
		}
				
	}
}
