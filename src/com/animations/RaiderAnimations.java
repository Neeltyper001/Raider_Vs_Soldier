package com.animations;

import java.awt.image.BufferedImage;

import com.constants.Actions;
import com.constants.GameResourcesPath;
import com.main.GamePanel;
import com.sprites.Sprites;

public class RaiderAnimations implements GameResourcesPath,Actions {
	
//	private GamePanel gamePanel;
	//default images

	private BufferedImage mainIdleImage;
	private BufferedImage mainWalkingImage;
	private BufferedImage mainRunningImage;
	private BufferedImage mainAttackingImage;
	private BufferedImage mainJumpingImage;
	private BufferedImage mainHurtingImage;
	private BufferedImage mainDeadImage;
	
	//left images
	private BufferedImage mainIdleLeftImage;
	private BufferedImage mainWalkingLeftImage;
	private BufferedImage mainRunningLeftImage;
	private BufferedImage mainAttackingLeftImage;
	private BufferedImage mainJumpingLeftImage;
	private BufferedImage mainHurtingLeftImage;
	private BufferedImage mainDeadLeftImage;
	
	// array defaults
	private BufferedImage idle [];
	private BufferedImage walking [];
	private BufferedImage attacking [];
	private BufferedImage running [];
	private BufferedImage jumping [];
	private BufferedImage hurting [];
	private BufferedImage dead [];	
	// array left
	private BufferedImage idleLeft [];
	private BufferedImage walkingLeft [];
	private BufferedImage runningLeft [];
	private BufferedImage attackingLeft [];
	private BufferedImage jumpingLeft [];
	private BufferedImage hurtingLeft [];
	private BufferedImage deadLeft [];	

	
	public RaiderAnimations() {
		this.mainIdleImage = new Sprites(RAIDER_IDLE).getImage();
		this.mainWalkingImage = new Sprites(RAIDER_WALKING).getImage();
		this.mainRunningImage = new Sprites(RAIDER_RUNNING).getImage();
		this.mainAttackingImage = new Sprites(RAIDER_ATTACKING).getImage();
		this.mainJumpingImage = new Sprites(RAIDER_JUMPING).getImage();
		this.mainHurtingImage = new Sprites(RAIDER_HURTING).getImage();
		this.mainDeadImage = new Sprites(RAIDER_DEAD).getImage();
		//LEFT
		this.mainIdleLeftImage = new Sprites(RAIDER_IDLE_LEFT).getImage();
		this.mainWalkingLeftImage = new Sprites(RAIDER_WALKING_LEFT).getImage();
		this.mainRunningLeftImage = new Sprites(RAIDER_RUNNING_LEFT).getImage();
		this.mainAttackingLeftImage = new Sprites(RAIDER_ATTACKING_LEFT).getImage();
		this.mainJumpingLeftImage = new Sprites(RAIDER_JUMPING_LEFT).getImage();
		this.mainHurtingLeftImage = new Sprites(RAIDER_HURTING_LEFT).getImage();
		this.mainDeadLeftImage = new Sprites(RAIDER_DEAD_LEFT).getImage();
		
		// Default animation initialization
		this.initRaiderIdleAnimation();
		this.initRaiderWalkingAnimation();
		this.initRaiderRunningAnimation();
		this.initRaiderAttackingAnimation();
		this.initRaiderJumpAnimation();
		this.initRaiderHurtingAnimation();
		this.initRaiderIdleLeftAnimation();
		this.initRaiderWalkingLeftAnimation();
		this.initRaiderRunningLeftAnimation();
		this.initRaiderAttackingLeftAnimation();
		this.initRaiderJumpLeftAnimation();
		this.initRaiderHurtingLeftAnimation();
	}
	
	//Default animations	
	public void initRaiderIdleAnimation() {
		this.idle = new BufferedImage[8];
		this.idle[0] = this.mainIdleImage.getSubimage(44, 42, 45, 86);
		this.idle[1] = this.mainIdleImage.getSubimage(170, 42, 45, 86);
		this.idle[2] = this.mainIdleImage.getSubimage(300, 42, 45, 86);
		this.idle[3] = this.mainIdleImage.getSubimage(426, 42, 45, 86);
		this.idle[4] = this.mainIdleImage.getSubimage(552, 42, 45, 86);
		this.idle[5] = this.mainIdleImage.getSubimage(684, 42, 45, 86);
		this.idle[6] = this.mainIdleImage.getSubimage(811, 42, 45, 86);
		this.idle[7] = this.mainIdleImage.getSubimage(938, 42, 45, 86);
	}
		
	 
	public void initRaiderWalkingAnimation() {
		this.walking = new BufferedImage[7];
		this.walking[0] = this.mainWalkingImage.getSubimage(47, 42, 45, 86);
		this.walking[1] = this.mainWalkingImage.getSubimage(165, 42, 45, 86);
		this.walking[2] = this.mainWalkingImage.getSubimage(293, 42, 45, 86);
		this.walking[3] = this.mainWalkingImage.getSubimage(421, 42, 45, 86);
		this.walking[4] = this.mainWalkingImage.getSubimage(551, 42, 45, 86);
		this.walking[5] = this.mainWalkingImage.getSubimage(679, 42, 45, 86);
		this.walking[6] = this.mainWalkingImage.getSubimage(805, 42, 45, 86);
	}
	
	public void initRaiderRunningAnimation() {
		this.running = new BufferedImage[8];
		this.running[0] = this.mainRunningImage.getSubimage(40, 42, 45, 86);
		this.running[1] = this.mainRunningImage.getSubimage(170, 42, 45, 86);
		this.running[2] = this.mainRunningImage.getSubimage(297, 42, 45, 86);
		this.running[3] = this.mainRunningImage.getSubimage(422, 42, 45, 86);
		this.running[4] = this.mainRunningImage.getSubimage(551, 42, 45, 86);
		this.running[5] = this.mainRunningImage.getSubimage(680, 42, 45, 86);
		this.running[6] = this.mainRunningImage.getSubimage(809, 42, 45, 86);
		this.running[7] = this.mainRunningImage.getSubimage(934, 42, 45, 86);
	}
	
	public void initRaiderAttackingAnimation() {
		this.attacking = new BufferedImage[4];
		this.attacking[0] = this.mainAttackingImage.getSubimage( 37, 42, 61, 86);
		this.attacking[1] = this.mainAttackingImage.getSubimage(172, 42, 61, 86);
		this.attacking[2] = this.mainAttackingImage.getSubimage(301, 42, 61, 86);
		this.attacking[3] = this.mainAttackingImage.getSubimage(434, 42, 61, 86);
	}
	
	public void initRaiderJumpAnimation() {
		this.jumping = new BufferedImage[7];
		this.jumping[0] = this.mainJumpingImage.getSubimage(41,42, 45, 86);
		this.jumping[1] = this.mainJumpingImage.getSubimage(172,42, 45, 86);
		this.jumping[2] = this.mainJumpingImage.getSubimage(295,42, 45, 86);
		this.jumping[3] = this.mainJumpingImage.getSubimage(424,42, 45, 86);
		this.jumping[4] = this.mainJumpingImage.getSubimage(553,42, 45, 86);
		this.jumping[5] = this.mainJumpingImage.getSubimage(682,42, 45, 86);
		this.jumping[6] = this.mainJumpingImage.getSubimage(810,42, 45, 86);
	}
	
	public void initRaiderHurtingAnimation() {
		this.hurting = new BufferedImage[3];
		this.hurting[0] = this.mainHurtingImage.getSubimage(38, 42 ,45, 86);
		this.hurting[1] = this.mainHurtingImage.getSubimage(167, 42 ,45, 86);
		this.hurting[2] = this.mainHurtingImage.getSubimage(295, 42 ,45, 86);
	}
	
	public void initRaiderDeadAnimation() {
		this.dead = new BufferedImage[5];
		this.dead[0] = this.mainDeadImage.getSubimage(34, 42 ,45, 86);
		this.dead[1] = this.mainDeadImage.getSubimage(159, 42 ,45, 86);
		this.dead[2] = this.mainDeadImage.getSubimage(298, 42 ,45, 86);
		this.dead[3] = this.mainDeadImage.getSubimage(429, 42 ,45, 86);
		this.dead[4] = this.mainDeadImage.getSubimage(565, 72 ,66, 86);
	}
	
	// LEFT ANIMATION
	public void initRaiderIdleLeftAnimation() {
		this.idleLeft = new BufferedImage[8];
		this.idleLeft[0] = this.mainIdleLeftImage.getSubimage(936, 42, 45, 86);
		this.idleLeft[1] = this.mainIdleLeftImage.getSubimage(807, 42, 45, 86);
		this.idleLeft[2] = this.mainIdleLeftImage.getSubimage(678, 42, 45, 86);
		this.idleLeft[3] = this.mainIdleLeftImage.getSubimage(551, 42, 45, 86);
		this.idleLeft[4] = this.mainIdleLeftImage.getSubimage(422, 42, 45, 86);
		this.idleLeft[5] = this.mainIdleLeftImage.getSubimage(295, 42, 45, 86);
		this.idleLeft[6] = this.mainIdleLeftImage.getSubimage(168, 42, 45, 86);
		this.idleLeft[7] = this.mainIdleLeftImage.getSubimage(40, 42, 45, 86);
	}
		
	public void initRaiderWalkingLeftAnimation() {
		this.walkingLeft = new BufferedImage[7];
		this.walkingLeft[0] = this.mainWalkingLeftImage.getSubimage(815, 42, 45, 86);
		this.walkingLeft[1] = this.mainWalkingLeftImage.getSubimage(685, 42, 45, 86);
		this.walkingLeft[2] = this.mainWalkingLeftImage.getSubimage(556, 42, 45, 86);
		this.walkingLeft[3] = this.mainWalkingLeftImage.getSubimage(425, 42, 45, 86);
		this.walkingLeft[4] = this.mainWalkingLeftImage.getSubimage(298, 42, 45, 86);
		this.walkingLeft[5] = this.mainWalkingLeftImage.getSubimage(171, 42, 45, 86);
		this.walkingLeft[6] = this.mainWalkingLeftImage.getSubimage(45, 42, 45, 86);
	}
	
	public void initRaiderRunningLeftAnimation() {
		this.runningLeft = new BufferedImage[8];
		this.runningLeft[0] = this.mainRunningLeftImage.getSubimage(933, 42, 45, 86);
		this.runningLeft[1] = this.mainRunningLeftImage.getSubimage(807, 42, 45, 86);
		this.runningLeft[2] = this.mainRunningLeftImage.getSubimage(680, 42, 45, 86);
		this.runningLeft[3] = this.mainRunningLeftImage.getSubimage(554, 42, 45, 86);
		this.runningLeft[4] = this.mainRunningLeftImage.getSubimage(425, 42, 45, 86);
		this.runningLeft[5] = this.mainRunningLeftImage.getSubimage(295, 42, 45, 86);
		this.runningLeft[6] = this.mainRunningLeftImage.getSubimage(167, 42, 45, 86);
		this.runningLeft[7] = this.mainRunningLeftImage.getSubimage(42, 42, 45, 86);
	}
	
	public void initRaiderAttackingLeftAnimation() {
		this.attackingLeft = new BufferedImage[3];
		this.attackingLeft[0] = this.mainAttackingLeftImage.getSubimage(413, 42, 61, 86);
		this.attackingLeft[1] = this.mainAttackingLeftImage.getSubimage(279, 42, 61, 86);
		this.attackingLeft[2] = this.mainAttackingLeftImage.getSubimage(147, 42, 61, 86);
		this.attackingLeft[2] = this.mainAttackingLeftImage.getSubimage( 17, 42, 61, 86);
	}
	
	public void initRaiderJumpLeftAnimation() {
		this.jumpingLeft = new BufferedImage[7];
		this.jumpingLeft[0] = this.mainJumpingLeftImage.getSubimage(810, 42, 45, 86);
		this.jumpingLeft[1] = this.mainJumpingLeftImage.getSubimage(682, 42, 45, 86);
		this.jumpingLeft[2] = this.mainJumpingLeftImage.getSubimage(553, 42, 45, 86);
		this.jumpingLeft[3] = this.mainJumpingLeftImage.getSubimage(424, 42, 45, 86);
		this.jumpingLeft[4] = this.mainJumpingLeftImage.getSubimage(294, 42, 45, 86);
		this.jumpingLeft[5] = this.mainJumpingLeftImage.getSubimage(168, 42, 45, 86);
		this.jumpingLeft[6] = this.mainJumpingLeftImage.getSubimage(42, 42, 45, 86);
	}
	
	public void initRaiderHurtingLeftAnimation() {
		this.hurtingLeft = new BufferedImage[3];
		this.hurtingLeft[0] = this.mainHurtingLeftImage.getSubimage(42, 42 ,45, 86);
		this.hurtingLeft[1] = this.mainHurtingLeftImage.getSubimage(168, 42, 45, 86);
		this.hurtingLeft[2] = this.mainHurtingLeftImage.getSubimage(298, 42, 45, 86);
	}
	
	public void initRaiderDeadLeftAnimation() {
		this.deadLeft = new BufferedImage[5];
		this.deadLeft[0] = this.mainDeadLeftImage.getSubimage(8, 72 ,45, 86);
		this.deadLeft[1] = this.mainDeadLeftImage.getSubimage(165, 42 ,45, 86);
		this.deadLeft[2] = this.mainDeadLeftImage.getSubimage(293, 42 ,45, 86);
		this.deadLeft[3] = this.mainDeadLeftImage.getSubimage(433, 42 ,45, 86);
		this.deadLeft[4] = this.mainDeadLeftImage.getSubimage(561, 72 ,45, 86);
	}
	
	
	public BufferedImage[] getRaiderActionAnimation(int actionType,int actionDirection) {
		
		switch( actionType ) {
		case WALKING : return actionDirection == RIGHT_DIRECTION ? this.walking : this.walkingLeft;
		case RUNNING: return actionDirection == RIGHT_DIRECTION ? this.running : this.runningLeft;
		case ATTACKING: return actionDirection == RIGHT_DIRECTION ? this.attacking : this.attackingLeft;
		case WALKING_VERTICAL: return actionDirection == RIGHT_DIRECTION ? this.walking : this.walkingLeft;
		default: return actionDirection == RIGHT_DIRECTION ? this.idle : this.idleLeft;

		}
	}

}
