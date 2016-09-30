package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.AntiTdGame.Util.MathStuff;

public class Tower extends Actor {
	
	double xp;
	double levelUp = 30;

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
		
		xp += 0.017;
		
		System.out.println(xp);
		
		if(xp >= levelUp){
			xp = 0;
			levelUp *= 1.25;
			fireRate /= 1.1;
			Range *= 1.1;
		}
	}
	
	public void paint(Graphics g) {
		if(level.debug){
			g.setColor(new Color(255,0,0,64));
			g.fillOval((int)(pos.getX() - Range), (int)(pos.getY() - Range), (int)(Range * 2), (int)(Range * 2));
			if(target != null){
				g.setColor(new Color(255,255,255,128));
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
	public double getInterval() {
		return this.fireRate;
	}


	/**
	 * 
	 * */
	public void setInterval(int interval) {
		this.fireRate = interval;
	}

}
