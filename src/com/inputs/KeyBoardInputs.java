package com.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.animations.MainAnimation;
import com.constants.Actions;
import com.constants.GameConstants;
import com.entities.Player;
import com.main.GamePanel;
import com.utils.ChangeAnimation;
import com.utils.ChangeDelta;

public class KeyBoardInputs implements KeyListener,Actions,GameConstants{
	
	Player player;
	MainAnimation mainAnimation;
	public KeyBoardInputs(Player player,MainAnimation mainAnimation ) {
		this.player = player;
//		this.mainAnimation = mainAnimation;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			
		case KeyEvent.VK_W:
				System.out.println("W is pressed");
				this.player.setPlayerCurrentStatus(WALKING);
				this.player.getChangePlayerAnimation().setPresentAction(WALKING_VERTICAL, DEFAULT_HORIZONTAL_DIRECTION);
				this.player.getChangeDelta().setYDeltaDir(UP_DIRECTION);
				this.player.getChangeDelta().changeYDelta(WALKING_SPEED);				
				break;
		case KeyEvent.VK_S:
				System.out.println("S is pressed");
				this.player.setPlayerCurrentStatus(WALKING);
				this.player.getChangePlayerAnimation().setPresentAction(WALKING_VERTICAL, DEFAULT_HORIZONTAL_DIRECTION);
				this.player.getChangeDelta().setYDeltaDir(DOWN_DIRECTION);
				this.player.getChangeDelta().changeYDelta(WALKING_SPEED);
				break;
		case KeyEvent.VK_A:
				System.out.println("A is pressed");
				this.player.setPlayerCurrentStatus(WALKING);
				this.player.getChangePlayerAnimation().setPresentAction(WALKING, LEFT_DIRECTION);
				this.player.getChangeDelta().setXDeltaDir(LEFT_DIRECTION);
				this.player.getChangeDelta().changeXDelta(WALKING_SPEED);
				break;
		case KeyEvent.VK_D:
				System.out.println("D is pressed");
				this.player.setPlayerCurrentStatus(WALKING);
				this.player.getChangePlayerAnimation().setPresentAction(WALKING,RIGHT_DIRECTION);
				this.player.getChangeDelta().setXDeltaDir(RIGHT_DIRECTION);
				this.player.getChangeDelta().changeXDelta(WALKING_SPEED);
				break;
				
		case KeyEvent.VK_Q:
			System.out.println("Q is pressed");
			this.player.setPlayerCurrentStatus(RUNNING);
			this.player.getChangePlayerAnimation().setPresentAction(RUNNING,LEFT_DIRECTION);
//			this.mainAnimation.setAnimationTickLimit(RUNNING_ANIMATION);
			this.player.getChangeDelta().changeXDelta(RUNNING_SPEED);
			break;
			
		case KeyEvent.VK_J:
			System.out.println("J is pressed");
			this.player.setPlayerCurrentStatus(ATTACKING);
			this.player.getChangePlayerAnimation().setPresentAction(ATTACKING,LEFT_DIRECTION);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:
				System.out.println("W is released");
				this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//				this.changeDelta.changeYDelta(-5);				
				break;
		case KeyEvent.VK_S:
				System.out.println("S is released");
				this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//				this.changeDelta.changeYDelta(5);
				break;
		case KeyEvent.VK_A:
				System.out.println("A is released");
				this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//				this.changeDelta.changeXDelta(-5);
				break;
		case KeyEvent.VK_D:
				System.out.println("D is released");
				this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//				this.changeDelta.changeXDelta(5);
				break;
				
		case KeyEvent.VK_Q:
			System.out.println("Q is released");
//			this.mainAnimation.setAnimationTickLimit(NON_RUNNING_ANIMATION);
			this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//			this.changeDelta.changeXDelta(5);
			break;
			
			
		case KeyEvent.VK_J:
			System.out.println("J is released");
			this.player.setPlayerCurrentStatus(IDLE);
			this.player.getChangePlayerAnimation().setPresentAction(IDLE,RIGHT_DIRECTION);
//			this.changeDelta.changeXDelta(5);
			break;
		}
		
		
			
	}

}
