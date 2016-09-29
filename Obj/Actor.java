package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	
	int fireRate;
	
	double Range;
	
	Actor target;
	
	BufferedImage sprite;
	
	boolean shooting;
	
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
		shooting = true;
		//target.takeDamage(1);
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
	
	public void setLevel(Level l){
		level = l;
	}

	/**
	 * @return the sprite
	 */
	public BufferedImage getSprite() {
		return sprite;
	}

	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the range
	 */
	public double getRange() {
		return Range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(double range) {
		Range = range;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @return the pos
	 */
	public Vector getPos() {
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(Vector pos) {
		this.pos = pos;
	}

	/**
	 * @return the target
	 */
	public Actor getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Actor target) {
		this.target = target;
	}
}