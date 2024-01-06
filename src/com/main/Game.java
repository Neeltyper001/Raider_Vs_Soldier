package com.main;


import com.utils.GameLoop;

public class Game {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;	
	
	public Game() {
		 gamePanel = new GamePanel();
		 gameWindow = new GameWindow(gamePanel);
		 gamePanel.setFocusable(true);
		 gamePanel.requestFocusInWindow();
		 startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(new GameLoop(gamePanel));
		gameThread.start();
	}
	
	// Generating EnemyLoop()

}
