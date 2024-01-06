package com.animations;

import java.awt.image.BufferedImage;

import com.constants.Actions;
import com.constants.GameResourcesPath;
import com.sprites.Sprites;

public class EnemyAnimations implements GameResourcesPath,Actions{
	
	private BufferedImage mainWalkingImage;
	private BufferedImage mainAttackingImage;
	private BufferedImage walking [];
	private BufferedImage attacking [];

	
	public EnemyAnimations() {
		this.mainWalkingImage = new Sprites(ENEMY_WALKING).getImage();
		this.mainAttackingImage = new Sprites(ENEMY_ATTACKING).getImage();
		this.initEnemyWalkingAnimation();
		this.initEnemyAttackingAnimation();
	}
	
		
	 
	public void initEnemyWalkingAnimation() {
		this.walking = new BufferedImage[7];
		this.walking[0] = this.mainWalkingImage.getSubimage(808, 42, 45, 86);
		this.walking[1] = this.mainWalkingImage.getSubimage(682, 42, 45, 86);
		this.walking[2] = this.mainWalkingImage.getSubimage(556, 42, 45, 86);
		this.walking[3] = this.mainWalkingImage.getSubimage(423, 42, 45, 86);
		this.walking[4] = this.mainWalkingImage.getSubimage(297, 42, 45, 86);
		this.walking[5] = this.mainWalkingImage.getSubimage(170, 42, 45, 86);
		this.walking[6] = this.mainWalkingImage.getSubimage( 41, 42, 45, 86);
	}
	
	public void initEnemyAttackingAnimation() {
		this.attacking = new BufferedImage[4];
		this.attacking[0] = this.mainAttackingImage.getSubimage(414, 42, 66, 86);
		this.attacking[1] = this.mainAttackingImage.getSubimage(287, 42, 66, 86);
		this.attacking[2] = this.mainAttackingImage.getSubimage(148, 42, 66, 86);
		this.attacking[3] = this.mainAttackingImage.getSubimage(16, 42, 66, 86);
	}
	
		
	

	public BufferedImage[] getEnemyActionAnimation(int actionType) {
		
		switch( actionType ) {
		case WALKING : return this.walking;
		case ATTACKING: return this.attacking;
		default: return this.walking;

		}
	}
}
