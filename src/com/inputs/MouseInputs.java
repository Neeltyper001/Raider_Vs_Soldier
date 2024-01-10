package com.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.utils.ChangeDelta;

public class MouseInputs implements MouseListener,MouseMotionListener {
	
	private ChangeDelta changeDelta;
	
	public  MouseInputs(ChangeDelta changeDelta) {
		this.changeDelta = changeDelta;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse is dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.changeDelta.setDelta(e.getX(),e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse is clicked");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse is pressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
