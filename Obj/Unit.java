package game.AntiTdGame.Obj;

import java.awt.Graphics;

public class Unit extends Actor {

	int speed;

	private final long CreationTime;

	/**
	 * Init Unit
	 */
	public Unit() {
		this.CreationTime = System.currentTimeMillis();
	}

	/**
	 * Draw Unit
	 */
	public void paint(Graphics g) {
	}

	/**
	 * Update Unit
	 */
	public void update() {
	}

	/**
	 * Get the lifetime of this unit (milliseconds)
	 */
	public long getLifeTime() {
		return this.CreationTime - System.currentTimeMillis();
	}

}
