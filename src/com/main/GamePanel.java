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
	private ChangeEnemyDelta changeEnemyDelta;
	private BufferedImage graphicImg;
	private Sprites playerSprites;
	private MainAnimation mainAnimation;
	private ChangeAnimation changeAnimation;
	private LoadBackground loadBackground;
	private BufferedImage enemyImage;
	private BufferedImage playerImage;
	private Collision collision;
	private Thread enemyGenerateThread;
	private Thread enemyDrawThread;
	private Player player;
	private Base base;
	private Enemy enemy;
	private EnemyManager enemyManager;
	private EnemyDrawer enemyDrawer;
	private Graphics g;
	private Visuals visuals;
	private boolean endGameLoop;

	
	public GamePanel(){
//		this.playerSprites = new Sprites(PLAYER_SPRITE);
		this.endGameLoop = false;
		this.loadBackground = new LoadBackground(GAME_BACKGROUND);
		this.visuals = new Visuals();
		this.player = new Player();
		this.base = new Base();
//		this.enemy = new Enemy(this.player);		
		this.enemyManager = new EnemyManager(this.player,this.base);
//		this.changeDelta = new ChangeDelta();
//		this.changeEnemyDelta = new ChangeEnemyDelta();
//		this.changeAnimation = new ChangeAnimation();
//		this.mainAnimation = new MainAnimation(this.changeAnimation); //changes
//		this.mainAnimation = new MainAnimation(this.player, this.enemy, this.enemyManager);
//		this.enemyDrawer = new EnemyDrawer(this.mainAnimation,this.enemyManager, this);
//		this.collision = new Collision(this.changeDelta , this.changeEnemyDelta, this.changeAnimation);
//		this.collision = new Collision(this.player, this.enemy);
		this.collision = new Collision(this.player, this.enemyManager);
		this.mouseInputs = new MouseInputs(this.changeDelta);
//		this.keyBoardInputs= new KeyBoardInputs(this.changeDelta,this.changeAnimation,this.mainAnimation);
		this.keyBoardInputs= new KeyBoardInputs(this.player,this.mainAnimation);
		this.generateEnemyThread();
		addKeyListener(keyBoardInputs);
//		addMouseListener(mouseInputs);
//		addMouseMotionListener(mouseInputs);	
	}
		
	
	private void generateEnemyThread() {
		this.enemyGenerateThread = new Thread(this.enemyManager);
//		this.enemyDrawThread = new Thread(this.enemyDrawer);
		this.enemyGenerateThread.start();
//		this.enemyDrawThread.start();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		graphics.drawImage(loadBackground.getBackground(),0,0,SCREEN_W,SCREEN_H,null);
//		graphics.drawImage(this.mainAnimation.getPlayerLatestAnimationImage(),this.player.getChangeDelta().getXDelta(),this.player.getChangeDelta().getYDelta(), 70, 120, null);
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
//		for(int i=0; i<enemyArray.size(); i++) {
//			enemyArray.get(i).drawEnemy(graphics);
//			enemyArray.get(i).enemyCollisionChecker();
//		}
		
		for(Enemy eachEnemy : enemyArray) {
			eachEnemy.drawEnemy(graphics);
			eachEnemy.enemyCollisionChecker();
			this.enemyManager.removeEnemyIf(eachEnemy, eachEnemy.checkDeadStatus(), eachEnemy.checkHasInvadedBase());
		}
		
		
//		graphics.drawImage(this.mainAnimation.getEnemyLatestAnimationImage(),this.enemy.getChangeEnemyDelta().getXDelta(),this.enemy.getChangeEnemyDelta().getYDelta(), 70, 120, null);
//		collision.collisionChecker();
		
//		graphics.drawImage(playerSprites.getImage().getSubimage(255, 1, 21, 33),this.changeDelta.getXDelta(),this.changeDelta.getYDelta(), 42, 66, null);
//		graphics.fillRect(this.changeDelta.getXDelta(),this.changeDelta.getYDelta(), 200, 50);
//		changeDelta.setAutoDelta();
//		changeDelta.setDeltaDir();		
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
