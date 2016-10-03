package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;

import engine.Common.Vector;
import game.AntiTdGame.Level;

public class Laser extends Projectile {

	int upi=0;
	int lifetime = 10;
	private Color color;

	public Laser(Actor a, Vector pos, double damage, Level level, Color color) {
		this.target = a;
		this.pos = pos;
		this.dmg = damage;
		this.level = level;
		this.color = color;
	}

	public void paint(Graphics g) {
		if (this.target != null) {
			g.setColor(color);
			g.drawLine((int) target.pos.getX(), (int) target.pos.getY(), (int) pos.getX(), (int) pos.getY());
			//if (upi==lifetime) this.target=null;
		}
	}

	public void update() {
		if (upi == lifetime) {
			target.takeDamage(dmg);
			level.removeFromLevel(this);
		} else {
			upi++;
		}
	}


	public void setLifeTime(int lt) {
		this.lifetime = lt;
	}

	public int getLifeTime() {
		return this.lifetime;
	}

}
