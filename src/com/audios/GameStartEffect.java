package com.audios;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.constants.GameResourcesPath;

public class GameStartEffect implements GameResourcesPath {
	private AudioInputStream audioInputStream;
	private URL gameStartUrl;
	private Clip gameStartClip;
	
	public GameStartEffect(){
		this.createGameStartURL();
		this.getGameStartPlayer();
	}
	
	private void getGameStartPlayer() {
		try {
			this.audioInputStream = AudioSystem.getAudioInputStream(gameStartUrl);
			this.gameStartClip = AudioSystem.getClip();
			this.gameStartClip.open(this.audioInputStream);			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	private void createGameStartURL() {
		this.gameStartUrl = getClass().getResource(GAME_START_2);
	}
	
	public void playGameStart() {
		this.gameStartClip.start();
	}
	
	public void stopGameStart() {
		this.gameStartClip.stop();
	}
}
