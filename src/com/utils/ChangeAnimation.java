package com.utils;

import com.constants.Actions;

public class ChangeAnimation implements Actions{
	
	private int presentAction;
	private int presentDirection;
	private int enemyPresentAction;
	
	public ChangeAnimation() {
		this.presentAction = IDLE;
		this.presentDirection = RIGHT_DIRECTION;
		this.enemyPresentAction = WALKING;
	}
	
	
	public int getPresentAction() {
		return this.presentAction;
	}
	
	public int getPresentDirection() {
		return this.presentDirection;
	}
	
	public int getEnemyPresentAction() {
		return this.enemyPresentAction;
	}
	
	public void setPresentAction(int presentAction , int presentDirection) {
		this.presentAction = presentAction;
		if(!(this.presentAction == RUNNING || this.presentAction == ATTACKING || this.presentAction == IDLE ||  this.presentAction == WALKING_VERTICAL )) 
			this.presentDirection = presentDirection;
	}
	
	public void setEnemyPresentAction(int presentAction) {
		this.enemyPresentAction = presentAction;
	}
	
	
}
