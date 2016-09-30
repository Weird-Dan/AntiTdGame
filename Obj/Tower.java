package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.AntiTdGame.Util.MathStuff;

public class Tower extends Actor {

	/**
	 * Update tower
	 */
	public void update() {
		super.update();
		target = level.getUnits().get(0);
		for(Unit u : level.getUnits()){
			double dist = MathStuff.distance(pos, u.pos);
			if(dist <= this.Range && dist < MathStuff.distance(pos, target.pos)){
				target = u;
			}
		}
	}
	
	public void paint(Graphics g) {
		if(level.debug){
			g.setColor(new Color(255,0,0,128));
			g.fillOval((int)(pos.getX() - Range), (int)(pos.getY() - Range), (int)(Range * 2), (int)(Range * 2));
			if(target != null){
				g.setColor(Color.white);
				g.drawLine((int)pos.getX(), (int)pos.getY(), (int)target.pos.getX(), (int)target.pos.getY());
			}
		}
		super.paint(g);
	}
	
	void explode(){
		level.KillTower(this);
	}


	/**
	 * 
	 * */
	public int getInterval() {
		return this.fireRate;
	}


	/**
	 * 
	 * */
	public void setInterval(int interval) {
		this.fireRate = interval;
	}

}
