package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;

import engine.Common.Vector;
import game.AntiTdGame.Level;

public class Laser extends Projectile {

	final long ct;
	private Color color;

	public Laser(Actor a, Vector pos, double damage, Level level, Color color) {
		this.target = a;
		this.pos = pos;
		this.dmg = damage;
		this.level = level;
		this.color = color;
		this.ct = System.currentTimeMillis();
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.drawLine((int) target.pos.getX(), (int) target.pos.getY(), (int) pos.getX(), (int) pos.getY());
	}

	public void update() {
		if (getLifetime() > 100) {
			target.takeDamage(dmg);
			level.removeFromLevel(this);
		}
	}

	public long getLifetime() {
		return System.currentTimeMillis() - this.ct;
	}

}
