package game.AntiTdGame.Obj;

import java.awt.Graphics;

import engine.Common.Vector;
import engine.Render.Renderable;
import game.AntiTdGame.Level;

public abstract class Projectile implements Renderable {

	Actor target;

	Vector pos;
	
	Level level;
	
	double dmg;

	@Override
	public void paint(Graphics g) {
		// paint projectile
	}

	@Override
	public void update() {
		// move
		// if on target, damage, and remove self
	}

}
