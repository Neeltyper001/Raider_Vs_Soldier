package com.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.animations.MainAnimation;
import com.main.GamePanel;

/** ATTENTION: 
EnemyDrawer class is currently not in use but can have some potential use in future. 
So if anyone wants to work with it can do whatever they want but make sure **THAT DO NOT REMOVE THIS CLASS**.
Also, currently, this class is not a part of the game build.
*/
public class EnemyDrawer  implements Runnable {
	
	private MainAnimation mainAnimation;
	private EnemyManager enemyManager;
	private GamePanel gamePanel;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200; 
	private Graphics g;
	
	public EnemyDrawer(MainAnimation mainAnimation, EnemyManager enemyManager, GamePanel gamePanel) {
		this.mainAnimation = mainAnimation;
		this.enemyManager = enemyManager;
		this.gamePanel = gamePanel;
		this.g = gamePanel.getGraphics();
	}
	
	private void drawThem() {
		ArrayList<Enemy> enemyArray = this.enemyManager.getEnemyArray();
		for(int i=0; i<enemyArray.size(); i++) {	
//			System.out.println(enemyArray.get(i).toString()+" "+this.gamePanel.getGraphics()+" of enemyDrawer class");
			if(this.gamePanel.getGraphics() != null)
			this.gamePanel.getGraphics().drawImage(mainAnimation.getEnemyLatestAnimationImage(i), enemyArray.get(i).getChangeEnemyDelta().getXDelta(), enemyArray.get(i).getChangeEnemyDelta().getYDelta(), 70,120 , null);
		}
	}
	
	
	
	public void checkTheCollision() {
		ArrayList<Enemy> enemyArray = enemyManager.getEnemyArray();
		
		for(Enemy eachEnemy : enemyArray) {
			eachEnemy.enemyCollisionChecker();
		}
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
//					this.updateGame();
					updates++;
					deltaU--;
				}
				
				if(deltaF >=1) {
//					System.out.println("Enemy Drawer working fine! and gamePanel is "+this.gamePanel.getGraphics());
//					this.drawThem();
//					this.checkTheCollision();
					frames++;	
					deltaF--;
				}
				
				
				if(System.currentTimeMillis() - lastCheck >= 1000) {
					lastCheck = System.currentTimeMillis();
					System.out.println("FPS : "+frames+" | UPS : "+updates);
					frames = 0;
					updates = 0;
				}
		}
}
}
