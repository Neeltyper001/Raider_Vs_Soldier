package com.utils;

import java.util.Random;

import com.constants.GameConstants;
import com.main.GamePanel;

public class ChangeEnemyDelta implements GameConstants{
	private int xDelta;
	private int yDelta;
	private int enemySpeed;
	
	
	public ChangeEnemyDelta() {
		this.xDelta = 1000;
		this.yDelta = spawnTheEnemy();
		this.enemySpeed = 1;
	}
	
	private int spawnTheEnemy() {
		int randomSpawnSpot = (new Random().nextInt(51) + 1)*5 + yDELTA_UPPER_LIMIT;
		return randomSpawnSpot;
	}
	// for keyboards
	public void changeXDelta() {
		this.xDelta -= this.enemySpeed;		
	}
	
	public void setEnemySpeed(int value) {
		this.enemySpeed = value;
	}
	
	public int getXDelta() {
		this.changeXDelta();
		return this.xDelta;
	}
	
	public int getYDelta() {
		return this.yDelta;
	}
}
