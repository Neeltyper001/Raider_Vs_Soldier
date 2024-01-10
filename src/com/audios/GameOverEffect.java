package com.audios;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.constants.GameResourcesPath;


public class GameOverEffect implements GameResourcesPath {
	private AudioInputStream audioInputStream;
	private URL gameOverUrl;
	private Clip gameOverClip;
	
	public GameOverEffect(){
		this.createGameOverURL();
		this.getGameOverPlayer();
	}
	
	private void getGameOverPlayer() {
		try {
			this.audioInputStream = AudioSystem.getAudioInputStream(gameOverUrl);
			this.gameOverClip = AudioSystem.getClip();
			this.gameOverClip.open(this.audioInputStream);			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	private void createGameOverURL() {
		this.gameOverUrl = getClass().getResource(GAME_OVER_2);
	}
	
	public void playGameOver() {
		this.gameOverClip.start();
	}
	
	public void stopGameOver() {
		this.gameOverClip.stop();
	}
}
