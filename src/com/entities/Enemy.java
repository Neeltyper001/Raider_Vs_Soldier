package com.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Action;

import com.animations.EnemyAnimations;
import com.constants.Actions;
import com.constants.AnimationConstants;
import com.utils.ChangeAnimation;
import com.utils.ChangeEnemyDelta;

import Graphics.EnemyVisuals;

public class Enemy extends Entity implements Actions, AnimationConstants{

	private ChangeEnemyDelta changeEnemyDelta;
	private ChangeAnimation changeEnemyAnimation;
	private Player player;
	private Base base;
	private EnemyAnimations enemyAnimations;
	private EnemyVisuals enemyVisuals;
	private BufferedImage [] enemyPresentAnimationType;
	private int enemyAnimationIndex;
	private int enemyAnimationTick = ENEMY_ANIMATION_TICK;
	private int enemyAnimationTickLimit = ENEMY_ANIMATION_TICK_LIMIT;
	
	public Enemy(Player player , Base base) {
		this.changeEnemyDelta = new ChangeEnemyDelta();
		this.changeEnemyAnimation = new ChangeAnimation();
		this.player = player;
		this.base = base;
		this.enemyAnimations = new EnemyAnimations();
		this.setHealth(50);
		this.enemyVisuals = new EnemyVisuals();
	}

	public ChangeEnemyDelta getChangeEnemyDelta() {
		return this.changeEnemyDelta;
	}

	public void setChangeEnemyDelta(ChangeEnemyDelta changeEnemyDelta) {
		this.changeEnemyDelta = changeEnemyDelta;
	}

	public ChangeAnimation getChangeEnemyAnimation() {
		return this.changeEnemyAnimation;
	}

	public void setChangeEnemyAnimation(ChangeAnimation changeEnemyAnimation) {
		this.changeEnemyAnimation = changeEnemyAnimation;
	}

	public void enemyCollisionChecker() {
		if(this.player.getChangeDelta().getYDelta() >= this.getChangeEnemyDelta().getYDelta() - 5 && this.player.getChangeDelta().getYDelta() <= this.getChangeEnemyDelta().getYDelta() + 5 
				&& this.player.getChangeDelta().getXDelta() <= this.getChangeEnemyDelta().getXDelta()) {
			this.getChangeEnemyAnimation().setEnemyPresentAction(ATTACKING);
			this.getChangeEnemyDelta().setEnemySpeed(0);
//			this.changeEnemyDelta.setEnemySpeed(0);
//			this.player.getChangePlayerAnimation().setPresentAction(HURTING, this.player.getChangePlayerAnimation().getPresentDirection());
			if(this.player.getPlayerCurrentStatus() == ATTACKING) {
				this.setHealth(-5);
				System.out.println("Enemy health "+this.getHealth());
			}
			this.player.setHealth(-1);
			
		}
		
		else {
			this.getChangeEnemyAnimation().setEnemyPresentAction(WALKING);
			this.getChangeEnemyDelta().setEnemySpeed(1);
			if(this.player.getPlayerCurrentStatus() == ATTACKING) {
				this.setHealth(-5);
				System.out.println("Enemy health "+this.getHealth());
			}
		}
	}
	
	public boolean checkDeadStatus() {
		if(this.health <= 0) {
			this.player.setPoints(5);
			return true;
		}
		
		return false;
	}
	
	public boolean checkHasInvadedBase() {
		if(this.getChangeEnemyDelta().getXDelta() <= 0) {
			this.base.setHealth(-5);
			System.out.println("Invaded base"+" base life remaining: "+this.base.getHealth());
			return true;
		}
		
		return false;
	}
	
	@Override
	public void setHealth(int health) {
		this.health += health;
	}
	
	@Override
	public int getHealth() {
		return this.health;
	}
	
	
	public BufferedImage getEnemyLatestAnimationImage() {
		int actionType = this.getChangeEnemyAnimation().getEnemyPresentAction();
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
	
	public void drawEnemy(Graphics g) {
		g.drawImage(this.getEnemyLatestAnimationImage(),this.getChangeEnemyDelta().getXDelta(), this.getChangeEnemyDelta().getYDelta(), 70,120 , null);
		g.setColor(this.enemyVisuals.getEmptyHealthBar());
		g.fillRect(this.getChangeEnemyDelta().getXDelta() + 30, this.getChangeEnemyDelta().getYDelta() - 30, 50, 5);
		g.setColor(this.enemyVisuals.getCurrentHealthBar());
		g.fillRect(this.getChangeEnemyDelta().getXDelta() + 30, this.getChangeEnemyDelta().getYDelta() - 30, this.getHealth(), 5);
	}
	

}
//&& this.player.getChangeDelta().getXDelta() <= this.getChangeEnemyDelta().getXDelta()