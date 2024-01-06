package com.main;

import javax.swing.JFrame;

import com.constants.GameConstants;

public class GameWindow implements GameConstants {
	private JFrame jframe;
	
	GameWindow(GamePanel gamePanel){
		jframe = new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(SCREEN_X,SCREEN_Y,SCREEN_W,SCREEN_H);		
//		jframe.setSize(500,500);
		jframe.add(gamePanel);
		jframe.setResizable(false);
		jframe.setVisible(true);
	}
}
