package com.entities;

public class Base extends Entity{
	
	
	public Base() {
		this.health = 150;
	}
	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public void setHealth(int damage) {
		this.health += damage;		
	}
	
	public boolean checkInvadeStatus() {
		if(this.health <= 0) {
			return true;
		}
		return false;
	}
	
}
