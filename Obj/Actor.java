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
 */
public class Actor implements Renderable {

	double SH = 100;
	double health = SH, damage = 3;

	Level level;

	/**
	 * Position
	 */
	Vector pos;

	double fireRate = 30;
	int fire;
	public double slowdown;

	double Range;

	Actor target;

	BufferedImage sprite;
	Color laserColor;

	// Projectile projectile;

	/**
	 * Draw to screen
	 */
	public void paint(Graphics g) {
		if (pos != null) {

			g.drawImage(sprite, (int) (pos.getX() - level.scale / 2), (int) (pos.getY() - level.scale / 2), null);

			if (health != SH) {
				int x = (int) (pos.getX() - level.scale / 2);
				int y = (int) (pos.getY() + level.scale / 2 + 1);

				g.setColor(Color.red);
				g.fillRect(x, y, (int) (level.scale), 4);
				g.setColor(Color.green);
				g.fillRect(x, y, (int) (level.scale * health / SH), 4);
			}
		}
	}

	/**
	 * Update actor
	 */
	public void update() {
		if (target != null && MathStuff.distance(pos, target.pos) <= this.Range
				&& (level.getUnits().contains(target) || level.getTowers().contains(target))) {
			fire++;
			if (fire >= fireRate * (slowdown + 1)) {
				fire = 0;
				shoot();
			}
		}

		if (slowdown > 0) {
			slowdown -= .21;
		} else {
			slowdown = 0;
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
	 * Subtract dmg from damage and check if the health is less than or equal to
	 * 0.
	 */
	public void takeDamage(double dmg) {
		health -= dmg;
		if (health <= 0) {
			explode();
		}
	}

	/*
	 * Blow stuff up when they die!!
	 */
	void explode() {
		level.removeFromLevel(this);
	}

	public void setLevel(Level l) {
		level = l;
	}

	/**
	 * @return the sprite
	 */
	public BufferedImage getSprite() {
		return sprite;
	}

	/**
	 * @param sprite
	 *            the sprite to set
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
	 * @param range
	 *            the range to set
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
	 * @param damage
	 *            the damage to set
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
	 * @param pos
	 *            the pos to set
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
	 * @param target
	 *            the target to set
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
	 * @param laserColor
	 *            the laserColor to set
	 */
	public void setLaserColor(Color laserColor) {
		this.laserColor = laserColor;
	}

}