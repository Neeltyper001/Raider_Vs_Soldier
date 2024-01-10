package com.animations;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.constants.Actions;
import com.entities.Enemy;
import com.entities.EnemyManager;
import com.entities.Player;
import com.utils.ChangeAnimation;

/** ATTENTION: 
 MainAnimation class is currently not in use but can have potential in future. 
 So if one wants to work with it can do whatever they want but make sure **THAT DO NOT REMOVE THIS CLASS**.
 Also, currently, this class is not a part of the game build.
 */

public class MainAnimation implements Actions {
	ChangeAnimation playerChangeAnimation;
	ChangeAnimation enemyChangeAnimation;
	RaiderAnimations raiderAnimations;
	EnemyAnimations enemyAnimations;
	BufferedImage [] presentAnimationType;
	BufferedImage [] enemyPresentAnimationType;
//	BufferedImage presentAnimationImage;
	private int animationIndex;
	private int animationTick=0;
	private int animationTickLimit = 15;
//	private int animationSpeed=15;
	
	private int enemyAnimationIndex;
	private int enemyAnimationTick=0;
	private int enemyAnimationTickLimit = 15;
	
	private Player player;
	private Enemy enemy;
	private EnemyManager enemyManager;
	// Changes
//	public MainAnimation(ChangeAnimation changeAnimation){
//		 this.playerChangeAnimation = changeAnimation;
//		 this.enemyChangeAnimation = changeAnimation;
//		 this.raiderAnimations = new RaiderAnimations();
//		 this.enemyAnimations = new EnemyAnimations();
//		 this.enemyManager = new EnemyManager();
//	}
	
	public MainAnimation(Player player, Enemy enemy, EnemyManager enemyManager){
//	 this.playerChangeAnimation = changeAnimation;
	 this.player = player;	
	 this.enemy = enemy;
	 this.enemyManager = enemyManager;
//	 this.enemyChangeAnimation = changeAnimation;
	 this.raiderAnimations = new RaiderAnimations();
	 this.enemyAnimations = new EnemyAnimations();
//	 this.enemyManager = new EnemyManager(this.player);
}
	
	public BufferedImage getEnemyLatestAnimationImage() {
		int actionType = this.enemy.getChangeEnemyAnimation().getEnemyPresentAction();
//		int actionType = this.enemyManager.getEnemyArray().get(0).getChangeEnemyAnimation().getEnemyPresentAction();
		this.enemyPresentAnimationType = enemyAnimations.getEnemyActionAnimation(actionType);
		
		
		this.enemyAnimationTick++;
		if(this.enemyAnimationTick >= this.enemyAnimationTickLimit) {
			this.enemyAnimationTick = 0;
			this.enemyAnimationIndex++;
			if(enemyAnimationIndex >= enemyPresentAnimationType.length ) {
				this.enemyAnimationIndex = 0;
			}
		}
		
		return this.enemyPresentAnimationType[this.enemyAnimationIndex];
	}
	
	// EnemyManager method
	   	public BufferedImage getEnemyLatestAnimationImage(int index) {
		int actionType = this.enemyManager.getEnemyArray().get(index).getChangeEnemyAnimation().getEnemyPresentAction();
		this.enemyPresentAnimationType = enemyAnimations.getEnemyActionAnimation(actionType);
		
		
		this.enemyAnimationTick++;
		if(this.enemyAnimationTick >= this.enemyAnimationTickLimit) {
			this.enemyAnimationTick = 0;
			this.enemyAnimationIndex++;
			if(enemyAnimationIndex >= enemyPresentAnimationType.length ) {
				this.enemyAnimationIndex = 0;
			}
		}
		
		return this.enemyPresentAnimationType[this.enemyAnimationIndex];
	} 

	
	
	
	public BufferedImage getPlayerLatestAnimationImage() {
		int actionType = this.player.getChangePlayerAnimation().getPresentAction();
		int actionDirection = this.player.getChangePlayerAnimation().getPresentDirection();
		this.presentAnimationType = raiderAnimations.getRaiderActionAnimation(actionType,actionDirection);
		
		
		this.animationTick++;
		if(this.animationTick >= this.animationTickLimit) {
			animationTick = 0;
			animationIndex++;
			if(animationIndex >= presentAnimationType.length ) {
				animationIndex = 0;
			}
		}

		return this.presentAnimationType[this.animationIndex];
	}
	
	public void setAnimationTickLimit(int value) {
		 this.animationTickLimit = value;
	}
}
