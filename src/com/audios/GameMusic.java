package com.audios;


import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import com.constants.GameResourcesPath;


public class GameMusic implements GameResourcesPath{
	
	private AudioInputStream audioInputStream;
	private URL gameMusicUrl;
	private Clip gameMusicClip;
	
	public GameMusic(){
		this.createGameMusicURL();
		this.getGameMusicPlayer();
	}
	
	private void getGameMusicPlayer() {
		try {
			this.audioInputStream = AudioSystem.getAudioInputStream(gameMusicUrl);
			this.gameMusicClip = AudioSystem.getClip();
			this.gameMusicClip.open(this.audioInputStream);			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	private void createGameMusicURL() {
		this.gameMusicUrl = getClass().getResource(GAME_MUSIC_2);
	}
	
	public void playGameMusic() {
		this.gameMusicClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopGameMusic() {
		this.gameMusicClip.stop();
	}
}
