package com.utils;

import com.main.GamePanel;

public class GameLoop implements Runnable {
	
	private final int FPS_SET = 100;
	private final int UPS_SET = 200; 
	GamePanel gamePanel;
	public GameLoop(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		double nanoTimePerFrame = 1000000000.0/this.FPS_SET;
		double nanoTimePerUpdate = 1000000000.0/this.UPS_SET;

		long lastCheck = System.currentTimeMillis();
		
		long previousUpdateTime = System.nanoTime();
		int frames = 0;
		int updates = 0;
		
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {
			long currentUpdateTime = System.nanoTime(); 
			
			deltaU += (currentUpdateTime - previousUpdateTime) / nanoTimePerUpdate;
			deltaF += (currentUpdateTime - previousUpdateTime) / nanoTimePerFrame;
			previousUpdateTime = currentUpdateTime;
			if(deltaU >= 1) {
//				this.updateGame();
				updates++;
				deltaU--;
			}
			
			if(deltaF >=1) {
				gamePanel.repaint();
				frames++;	
				deltaF--;
			}
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS : "+frames+" | UPS : "+updates);
				frames = 0;
				updates = 0;
			}
					
			
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        if(this.gamePanel.getEndGameLoop()) {
	        	break;
	        }
	        	   
		}
				
	}
}
