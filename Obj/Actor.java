package game.AntiTdGame.Obj;

import java.awt.Graphics;

import engine.Common.Vector;
import engine.Render.Renderable;
import game.AntiTdGame.Level;


/**
 * @autor Weird-Dan
 * */
public class Actor implements Renderable {

	int health, damage;
	
	Level level;
	
	/**
	 * Position
	 * */
	Vector pos;
	
	double rotation;
	
	double fireRate;
	
	int Range;
	
	Actor target;
	
	//Projectile projectile;

	/**
	 * Draw to screen
	 * */
	public void paint(Graphics g) {
		
	}

	/**
	 * Update actor
	 * */
	public void update() {
		
	}
	
	/*
	 * Shoot a projectile at the target
	 */
	public void shoot() {
		
	}
	
	/*
	 * Subtract dmg from damage and check if the health is less than or equal to 0.
	 */
	public void takeDamage(int dmg) {
		damage -= dmg;
		if(damage <= 0){
			explode();
		}
	}
	
	/*
	 * Blow stuff up when they die!!
	 */
	void explode(){
		level.removeFromLevel(this);
	}

}
