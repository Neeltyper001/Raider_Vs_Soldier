package com.entities;

public abstract class Entity {
	protected int health;	
	protected abstract  void setHealth(int damage);	
	protected abstract int getHealth(); 	
}
