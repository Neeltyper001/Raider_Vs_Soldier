package com.constants;

public interface Attributes {
	
	// COMMON ATTRIBUTES
	int NILL = 0;
	
	// ENEMY ATTRIBUTES
	int ENEMY_MAX_HEALTH = 50;
	int DAMAGE_TO_ENEMY = -5;
	int ENEMY_WIDTH = 70;
	int ENEMY_HEIGHT = 120;
	int ENEMY_HEALTH_BAR_COORDS = 30;
	int ENEMY_HEALTH_BAR_HEIGHT = 5;
	int ENEMY_COLLISION_LIMIT = 5;
	
	// PLAYER ATTRIBUTES
	int PLAYER_MAX_HEALTH = 500;
	int DAMAGE_TO_PLAYER = -1;
	int POINTS_TO_PLAYER = 5;
	int STARTING_POINTS_TO_PLAYER = 0;
	int PLAYER_WIDTH = 70;
	int PLAYER_HEIGHT = 120;
	
	// BASE ATTRIBUTES
	int DAMAGE_TO_BASE = -5;
}