package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;

import engine.Common.Vector;
import game.AntiTdGame.Level;

public class Laser extends Projectile {

	final long ct;
	int lifetime = 100;
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
		if(level.getTowers().contains(target) || level.getUnits().contains(target)){
			g.setColor(color);
			g.drawLine((int) target.pos.getX(), (int) target.pos.getY(), (int) pos.getX(), (int) pos.getY());
		}else{
			level.removeFromLevel(this);
		}
	}

	public void update() {
		if (getLifetime() > lifetime) {
			target.takeDamage(dmg);
			level.removeFromLevel(this);
		}
	}

	public long getLifetime() {
		return System.currentTimeMillis() - this.ct;
	}

}
