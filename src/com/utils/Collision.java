package com.utils;

import com.constants.Actions;
import com.entities.Enemy;
import com.entities.EnemyManager;
import com.entities.Player;

public class Collision implements Actions{
//	private	ChangeDelta changeDelta;
//	private	ChangeEnemyDelta changeEnemyDelta;
//	private	ChangeAnimation changeAnimation;
	private Player player;
	private Enemy enemy;
	private EnemyManager enemyManager;
		
//		public Collision(ChangeDelta changeDelta, ChangeEnemyDelta changeEnemyDelta, ChangeAnimation changeAnimation) {
//			this.changeDelta = changeDelta;
//			this.changeEnemyDelta = changeEnemyDelta;
//			this.changeAnimation = changeAnimation;
//		}
		
//		public Collision(Player player , Enemy enemy) {
////			this.changeDelta = changeDelta;
////			this.changeEnemyDelta = changeEnemyDelta;
////			this.changeAnimation = changeAnimation;
//			this.player = player;
//			this.enemy = enemy;
//		}
		
		public  Collision(Player player , EnemyManager enemyManager) {
			this.player = player;
			this.enemyManager = enemyManager;
		}
		
//		public void collisionChecker() {
//			if(this.player.getChangeDelta().getYDelta() == this.enemy.getChangeEnemyDelta().getYDelta() && this.player.getChangeDelta().getXDelta() <= this.enemy.getChangeEnemyDelta().getXDelta()) {
//				this.enemy.getChangeEnemyAnimation().setEnemyPresentAction(ATTACKING);
////				this.changeEnemyDelta.setEnemySpeed(0);
//				this.enemy.getChangeEnemyDelta().setEnemySpeed(0);
//			}
//			
//			else {
//				this.enemy.getChangeEnemyAnimation().setEnemyPresentAction(WALKING);
//				this.enemy.getChangeEnemyDelta().setEnemySpeed(1);
//			}
//		}
		
		public void collisionChecker() {
			for(Enemy everyEnemy : enemyManager.getEnemyArray()) {
				if(this.player.getChangeDelta().getYDelta() == everyEnemy.getChangeEnemyDelta().getYDelta() && this.player.getChangeDelta().getXDelta() <= everyEnemy.getChangeEnemyDelta().getXDelta()) {
					everyEnemy.getChangeEnemyAnimation().setEnemyPresentAction(ATTACKING);
//				this.changeEnemyDelta.setEnemySpeed(0);
					everyEnemy.getChangeEnemyDelta().setEnemySpeed(0);
					System.out.println("Collision occured");
					this.player.setHealth(-1);
				}
				
				else {
					everyEnemy.getChangeEnemyAnimation().setEnemyPresentAction(WALKING);
					everyEnemy.getChangeEnemyDelta().setEnemySpeed(1);
				}
				
			}
		}
}
