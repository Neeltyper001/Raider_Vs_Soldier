package com.entities;

import java.util.ArrayList;

import com.animations.EnemyAnimations;

public class EnemyManager  implements Runnable {
	
	private ArrayList<Enemy> enemyArray;
	private Thread enemyDrawerThread;
//	private int MAX_COUNT = 3;
	private int PRESENT_COUNT = 1;
	private int COUNT_DOWN = 10000;
	private Player player;
	private Base base;
	
	public EnemyManager(Player player, Base base) {
		this.enemyArray = new ArrayList<>();	
		this.player = player;
		this.base = base;
	}
	
	public ArrayList<Enemy> getEnemyArray(){
		return this.enemyArray;
	}
	
	public void setEnemyArray() {
		
		for(int i=0 ; i<PRESENT_COUNT; i++) {
			Enemy enemy = new Enemy(this.player, this.base);
			this.enemyArray.add(enemy);			
		}
	}
	
	public void removeEnemyIf(Enemy enemy, boolean deadStatus, boolean invasionStatus) {
		if(deadStatus || invasionStatus)
		this.enemyArray.remove(enemy);
	}
	
	
	@Override
	public void run() {
		
		
		while(true) {
			if(this != null) {
					this.setEnemyArray();
					System.out.println("Enemy Manager thread is running with count "+this.PRESENT_COUNT);									
			}
			
            try {
                // Sleep for 1000 milliseconds (1 second)
                Thread.sleep(this.COUNT_DOWN);
            } catch (InterruptedException e) {
                // Handle the InterruptedException if needed
                e.printStackTrace();
            }
            
            if(this.COUNT_DOWN > 4000)
            	this.COUNT_DOWN-=1000;
            
            if(this.player.checkDeadStatus()) {
            	break;
            }
		}
		
		
	}
}
