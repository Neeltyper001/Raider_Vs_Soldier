package com.main;


import com.utils.GameLoop;

import Graphics.SplashScreen;

public class Game {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private SplashScreen splashScreen;
	private Thread gameThread;	
	
	public Game() {
		 this.splashScreen = new SplashScreen();
		 this.gamePanel = new GamePanel();
		 this.gameWindow = new GameWindow(gamePanel);		 
		 this.gamePanel.setFocusable(true);
		 this.gamePanel.requestFocusInWindow();
		 startGameLoop();
	}
	
	private void startGameLoop() {
		this.gameThread = new Thread(new GameLoop(gamePanel));
		this.gameThread.start();
	}		
}
