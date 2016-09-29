package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;

import game.AntiTdGame.Util.MathStuff;

public class Tower extends Actor {

	/**
	 * Fire-interval of tower (default is 60)
	 * */

	/**
	 * Update tower
	 */
	public void update() {
		super.update();
		
		for(Unit u : level.getUnits()){
			if(MathStuff.distance(pos, u.pos) <= this.Range){
				target = u;
				break;
			}
		}
	}
	
	public void paint(Graphics g) {
		if(level.debug){
			g.setColor(new Color(255,0,0,128));
			g.fillOval((int)(pos.getX() - Range), (int)(pos.getY() - Range), (int)(Range * 2), (int)(Range * 2));
		}
		super.paint(g);
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
