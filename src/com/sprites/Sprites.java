package com.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Sprites {
	BufferedImage img;
	String resourcePath;
	public Sprites(String resourcePath) {
		this.resourcePath = resourcePath;
		importImage();
	}
	
	private void importImage() {
		InputStream inputStream = getClass().getResourceAsStream(this.resourcePath);
		try {
			img = ImageIO.read(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public BufferedImage getImage() {
		return this.img;
	}
}
