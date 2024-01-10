package com.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.animations.EnemyAnimations;
import com.constants.Actions;
import com.constants.AnimationConstants;
import com.constants.Attributes;
import com.utils.ChangeAnimation;
import com.utils.ChangeEnemyDelta;

import Graphics.EnemyVisuals;

public class Enemy extends Entity implements Actions, AnimationConstants, Attributes{

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
		this.setHealth(ENEMY_MAX_HEALTH);
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
		if(this.player.getChangeDelta().getYDelta() >= this.getChangeEnemyDelta().getYDelta() - ENEMY_COLLISION_LIMIT && this.player.getChangeDelta().getYDelta() <= this.getChangeEnemyDelta().getYDelta() + ENEMY_COLLISION_LIMIT 
				&& this.player.getChangeDelta().getXDelta() <= this.getChangeEnemyDelta().getXDelta()) {
			this.getChangeEnemyAnimation().setEnemyPresentAction(ATTACKING);
			this.getChangeEnemyDelta().setEnemySpeed(NILL);
			if(this.player.getPlayerCurrentStatus() == ATTACKING && this.player.getChangePlayerAnimation().getPresentDirection() == RIGHT_DIRECTION) {
				this.setHealth(DAMAGE_TO_ENEMY);				
			}
			this.player.setHealth(DAMAGE_TO_PLAYER);
			
		}
		
		else {
			this.getChangeEnemyAnimation().setEnemyPresentAction(WALKING);
			this.getChangeEnemyDelta().setEnemySpeed(1);
			if(this.player.getPlayerCurrentStatus() == ATTACKING && this.player.getChangePlayerAnimation().getPresentDirection() == LEFT_DIRECTION && this.player.getChangeDelta().getXDelta() > this.getChangeEnemyDelta().getXDelta()
					&& this.player.getChangeDelta().getYDelta() >= this.getChangeEnemyDelta().getYDelta() - ENEMY_COLLISION_LIMIT && this.player.getChangeDelta().getYDelta() <= this.getChangeEnemyDelta().getYDelta() + ENEMY_COLLISION_LIMIT) {
				this.setHealth(DAMAGE_TO_ENEMY);				
			}
		}
	}
	
	public boolean checkDeadStatus() {
		if(this.health <= NILL) {
			this.player.setPoints(POINTS_TO_PLAYER);
			return true;
		}
		
		return false;
	}
	
	public boolean checkHasInvadedBase() {
		if(this.getChangeEnemyDelta().getXDelta() <= NILL) {
			this.base.setHealth(DAMAGE_TO_BASE);			
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
		this.enemyPresentAnimationType = enemyAnimations.getEnemyActionAnimation(actionType);
				
		this.enemyAnimationTick++;
		if(this.enemyAnimationTick >= this.enemyAnimationTickLimit) {
			this.enemyAnimationTick = ENEMY_ANIMATION_TICK;
			this.enemyAnimationIndex++;
			if(enemyAnimationIndex >= enemyPresentAnimationType.length ) {
				this.enemyAnimationIndex = ENEMY_ANIMATION_STARTING_INDEX;
			}
		}
		
		return this.enemyPresentAnimationType[this.enemyAnimationIndex];
	}
	
	public void drawEnemy(Graphics g) {
		g.drawImage(this.getEnemyLatestAnimationImage(),this.getChangeEnemyDelta().getXDelta(), this.getChangeEnemyDelta().getYDelta(), ENEMY_WIDTH, ENEMY_HEIGHT , null);
		g.setColor(this.enemyVisuals.getEmptyHealthBar());
		g.fillRect(this.getChangeEnemyDelta().getXDelta() + ENEMY_HEALTH_BAR_COORDS, this.getChangeEnemyDelta().getYDelta() - ENEMY_HEALTH_BAR_COORDS, ENEMY_MAX_HEALTH, ENEMY_HEALTH_BAR_HEIGHT);
		g.setColor(this.enemyVisuals.getCurrentHealthBar());
		g.fillRect(this.getChangeEnemyDelta().getXDelta() + ENEMY_HEALTH_BAR_COORDS, this.getChangeEnemyDelta().getYDelta() - ENEMY_HEALTH_BAR_COORDS, this.getHealth(), ENEMY_HEALTH_BAR_HEIGHT);
	}
	

}
