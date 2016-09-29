package game.AntiTdGame.Obj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.AntiTdGame.Util.MathStuff;

public class Tower extends Actor {

	/**
	 * Fire-interval of tower (default is 60)
	 * */

	/**
	 * Draw tower
	 */
	public void paint(Graphics g) {
		g.drawImage(sprite.getScaledInstance((int) level.scale / 2, (int) level.scale / 2, BufferedImage.SCALE_DEFAULT),
				(int) (pos.getX() - level.scale / 4), (int) (pos.getY() - level.scale / 4), null);
	}

	/**
	 * Update tower
	 */
	public void update() {
		if(MathStuff.distance(pos, target.pos) <= this.Range){
			shoot();
		}
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
