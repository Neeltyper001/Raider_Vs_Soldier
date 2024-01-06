package com.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.utils.ChangeAnimation;
import com.utils.ChangeDelta;
import com.animations.RaiderAnimations;
import com.constants.Actions;
import com.constants.AnimationConstants;

public class Player extends Entity implements AnimationConstants,Actions{
	
	private ChangeDelta changeDelta;
	private ChangeAnimation changePlayerAnimation;
	private BufferedImage [] presentAnimationType;
	private RaiderAnimations raiderAnimations;
	private int animationTick = ANIMATION_TICK;
	private int animationTickLimit = ANIMATION_TICK_LIMIT;
	private int animationIndex;
	private int currentStatus;
	private int points;
	
	
	public Player() {
		this.health = 500;
		this.changeDelta = new ChangeDelta();
		this.changePlayerAnimation = new ChangeAnimation();
		this.raiderAnimations = new RaiderAnimations();
		this.setPlayerCurrentStatus(IDLE);
		this.points = 0;
	}

	public ChangeDelta getChangeDelta() {
		return this.changeDelta;
	}

	public void setChangeDelta(ChangeDelta changeDelta) {
		this.changeDelta = changeDelta;
	}

	public ChangeAnimation getChangePlayerAnimation() {
		return this.changePlayerAnimation;
	}

	public void setChangePlayerAnimation(ChangeAnimation changePlayerAnimation) {
		this.changePlayerAnimation = changePlayerAnimation;
	}
	
	public void setPlayerCurrentStatus(int status) {
		this.currentStatus = status;
	}
	
	public int getPlayerCurrentStatus() {
		return this.currentStatus;
	}
	
	public String getPoints() {		
		return ""+this.points;
	}
	
	public void setPoints(int point) {
		this.points += point;
	}
	
	@Override
	public void setHealth(int health) {
		System.out.println("delivered health: "+health);
		this.health += health;
	}
	@Override
	public int getHealth() {
		System.out.println("Player health: "+this.health);
		return this.health;
	}
	
	public boolean checkDeadStatus() {
		if(this.health <= 0) {
			return true;
		}
		
		return false;
	}
	
	public BufferedImage getPlayerLatestAnimationImage() {
		int actionType = this.getChangePlayerAnimation().getPresentAction();
		int actionDirection = this.getChangePlayerAnimation().getPresentDirection();
		this.presentAnimationType = raiderAnimations.getRaiderActionAnimation(actionType,actionDirection);
		System.out.println(this.presentAnimationType.toString());
		if(actionType == 5) {
			System.out.println("LENGTH"+this.presentAnimationType.length);
		}
		
		
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
	
	public void drawPlayer(Graphics g) {
		g.drawImage(this.getPlayerLatestAnimationImage(),this.getChangeDelta().getXDelta(),this.getChangeDelta().getYDelta(), 70, 120, null);
	}
}
