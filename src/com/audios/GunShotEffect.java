package com.audios;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.constants.GameResourcesPath;

public class GunShotEffect implements GameResourcesPath {	
	private AudioInputStream audioInputStream;
	private URL gunShotUrl;
	private Clip gunShotClip;
	
	public GunShotEffect(){
		this.createGunShotURL();
		this.getGunShotPlayer();
	}
	
	private void getGunShotPlayer() {
		try {
			this.audioInputStream = AudioSystem.getAudioInputStream(gunShotUrl);
			this.gunShotClip = AudioSystem.getClip();
			this.gunShotClip.open(this.audioInputStream);			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	private void createGunShotURL() {
		this.gunShotUrl = getClass().getResource(GUN_SHOT_2);
	}
	
	public void playGunShot() {
		this.gunShotClip.setMicrosecondPosition(0);
		this.gunShotClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopGunShot() {
		this.gunShotClip.stop();
	}
}
