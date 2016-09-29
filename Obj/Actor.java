package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Common.Vector;
import engine.Render.Renderable;
import game.AntiTdGame.Level;
import game.AntiTdGame.Obj.Laser;
import game.AntiTdGame.Util.MathStuff;


/**
 * @autor Weird-Dan
 * */
public class Actor implements Renderable {

	double health = 100, damage = 5;
	
	Level level;
	
	/**
	 * Position
	 * */
	Vector pos;
	
	double rotation;
	
	int fireRate = 60;
	int fire;
	
	double Range;
	
	Actor target;
	
	BufferedImage sprite;
	Color laserColor;
	
	
	//Projectile projectile;

	/**
	 * Draw to screen
	 * */
	public void paint(Graphics g) {
		g.drawImage(sprite.getScaledInstance((int) level.scale, (int) level.scale, BufferedImage.SCALE_DEFAULT),
				(int) (pos.getX() - level.scale / 2), (int) (pos.getY() - level.scale / 2), null);
	}

	/**
	 * Update actor
	 * */
	public void update() {
		if(target != null && MathStuff.distance(pos, target.pos) <= this.Range && level.getUnits().contains(target)){
			fire++;
			if(fire >= fireRate){
				fire = 0;
				shoot();
			}
		}
	}
	
	/*
	 * Shoot a projectile at the target
	 */
	public void shoot() {
		Laser l = new Laser(target, pos, damage, level, laserColor);
		level.addToLevel(l);
	}
	
	/*
	 * Subtract dmg from damage and check if the health is less than or equal to 0.
	 */
	public void takeDamage(double dmg) {
		health -= dmg;
		if(health <= 0){
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
		Range = range * level.scale;
	}

	/**
	 * @return the damage
	 */
	public double getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(double damage) {
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

	/**
	 * @return the laserColor
	 */
	public Color getLaserColor() {
		return laserColor;
	}

	/**
	 * @param laserColor the laserColor to set
	 */
	public void setLaserColor(Color laserColor) {
		this.laserColor = laserColor;
	}
}