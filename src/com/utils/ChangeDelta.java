package com.utils;

import com.constants.Actions;
import com.constants.GameConstants;
import com.main.GamePanel;

public class ChangeDelta implements GameConstants,Actions{
//	private GamePanel gamePanel;
	private float xDelta;
	private float yDelta;
	private float xDirMov;
	private float yDirMov;
	private int xDeltaDir;
	private int yDeltaDir;

	
	public ChangeDelta() {
		this.xDelta = 20;
		this.yDelta = 300;
		this.xDirMov = 0.1f;
		this.yDirMov = 0.1f;
//		this.gamePanel = gamePanel;
		this.xDeltaDir = 1;
		this.yDeltaDir = 1;		
	}
	// for keyboards
	public void changeXDelta(int value) {
		this.xDelta += value*this.xDeltaDir;	
	}
	// for keyboards
	public void changeYDelta(int value) {	
		if(this.yDelta <= yDELTA_LOWER_LIMIT && this.yDeltaDir == DOWN_DIRECTION) {
			this.yDelta += value*this.yDeltaDir;			
		}
		
		if(this.yDelta >= yDELTA_UPPER_LIMIT && this.yDeltaDir == UP_DIRECTION) {
			this.yDelta += value*this.yDeltaDir;			
		}

	}
	
	// for mouse
	public void setDelta(int valueX, int valueY) {
		this.xDelta = valueX;
		this.yDelta = valueY;
	}
	
	public void setAutoDelta() {		
		this.xDelta += this.xDirMov;
		this.yDelta += this.yDirMov;
	}
//	
//	public void setDeltaDir() {		
//		if(this.xDelta > 900 || this.xDelta < 0 ) {
//			this.xDirMov = this.xDirMov * -1;
//		}
//		if(this.yDelta > 600 || this.yDelta < 0 ) {
//			this.yDirMov = this.yDirMov * -1;
//		}
//	}
	
	public void setXDeltaDir(int dir) {
		this.xDeltaDir  = dir;
	}
	
	public void setYDeltaDir(int dir) {
		this.yDeltaDir = dir;
	}
	
	
	public int getXDelta() {
		return (int)this.xDelta;
	}
	
	public int getYDelta() {
		return (int)this.yDelta;
	}
	
}
