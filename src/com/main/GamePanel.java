package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.animations.MainAnimation;
import com.constants.Actions;
import com.constants.GameConstants;
import com.constants.GameResourcesPath;
import com.entities.Base;
import com.entities.Enemy;
import com.entities.EnemyDrawer;
import com.entities.EnemyManager;
import com.entities.Player;
import com.inputs.KeyBoardInputs;
import com.inputs.MouseInputs;
import com.sprites.Sprites;
import com.utils.ChangeAnimation;
import com.utils.ChangeDelta;
import com.utils.ChangeEnemyDelta;
import com.utils.Collision;

import Graphics.LoadBackground;
import Graphics.Visuals;

public class GamePanel extends JPanel implements GameResourcesPath,Actions,GameConstants{

	private MouseInputs mouseInputs;	
	private KeyBoardInputs keyBoardInputs;
	private ChangeDelta changeDelta;
	private MainAnimation mainAnimation;
	private LoadBackground loadBackground;
	private Collision collision;
	private Thread enemyGenerateThread;
	private Player player;
	private Base base;
	private EnemyManager enemyManager;
	private Graphics g;
	private Visuals visuals;
	private boolean endGameLoop;

	
	public GamePanel(){
		this.endGameLoop = false;
		this.loadBackground = new LoadBackground(GAME_BACKGROUND);
		this.visuals = new Visuals();
		this.player = new Player();
		this.base = new Base();		
		this.enemyManager = new EnemyManager(this.player,this.base);
//		this.collision = new Collision(this.player, this.enemyManager);
		this.mouseInputs = new MouseInputs(this.changeDelta);
		this.keyBoardInputs= new KeyBoardInputs(this.player,this.mainAnimation);
		this.generateEnemyThread();
		addKeyListener(keyBoardInputs);	
	}
		
	
	private void generateEnemyThread() {
		this.enemyGenerateThread = new Thread(this.enemyManager);
		this.enemyGenerateThread.start();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		graphics.drawImage(loadBackground.getBackground(),0,0,SCREEN_W,SCREEN_H,null);
		this.player.drawPlayer(graphics);
		graphics.setColor(this.visuals.getEmptyHealthBar());
		graphics.fillRect(21,50,500,20);
		graphics.setColor(this.visuals.getCurrentHealthBar());
		graphics.fillRect(21, 50, this.player.getHealth(),20 );
		
		graphics.setColor(this.visuals.getFontColor());
		graphics.setFont(this.visuals.getFont());
		graphics.drawString("Player", 30 , 100);
		
		graphics.setColor(this.visuals.getEmptyBaseLifeBar());
		graphics.fillRect(21,130,150,20);
		graphics.setColor(this.visuals.getCurrentBaseLifeBar());
		graphics.fillRect(21, 130, this.base.getHealth(),20 );
		
		graphics.setColor(this.visuals.getFontColor());
		graphics.setFont(this.visuals.getFont());
		graphics.drawString("Base", 30 , 180);
		
		graphics.setColor(this.visuals.getFontColor());
		graphics.setFont(this.visuals.getFont());
		graphics.drawString("Points: ", 850 , 80);
		
		graphics.setColor(this.visuals.getFontColor());
		graphics.setFont(this.visuals.getFont());
		graphics.drawString(this.player.getPoints(), 950 , 80);
		
		if(this.player.checkDeadStatus() || this.base.checkInvadeStatus()) {
			graphics.setColor(this.visuals.getFontColor());
			graphics.setFont(this.visuals.getFont());
			graphics.drawString("Game Over", 500 , 350);
			this.setEndGameLoop(true);
		}
		
		ArrayList<Enemy> enemyArray = this.enemyManager.getEnemyArray();
		
		for(Enemy eachEnemy : enemyArray) {
			eachEnemy.drawEnemy(graphics);
			eachEnemy.enemyCollisionChecker();
			this.enemyManager.removeEnemyIf(eachEnemy, eachEnemy.checkDeadStatus(), eachEnemy.checkHasInvadedBase());
		}
			
	}
	
	
	
	public Graphics getGraphicsPanel() {
		return this.g;
	}
	
	public void setEndGameLoop(boolean endGameLoop) {
		this.endGameLoop = endGameLoop;
	}
	
	public boolean getEndGameLoop() {
		return this.endGameLoop;
	}
}
