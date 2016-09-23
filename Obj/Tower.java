package game.AntiTdGame.Obj;

import java.awt.Graphics;

public class Tower extends Actor {

	int range;

	Unit target;

	/**
	 * Fire-interval of tower (default is 60)
	 * */
	private int interval = 60;

	/**
	 * Draw tower
	 */
	public void paint(Graphics g) {

	}

	/**
	 * Update tower
	 */
	public void update() {

	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

}
