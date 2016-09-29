package game.AntiTdGame.Obj;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.ReadWrite.Read;
import game.AntiTdGame.Util.Path;

public class Unit extends Actor {

	double speed = 5;
	public Path path;

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
		g.drawImage(sprite.getScaledInstance((int) level.scale / 2, (int) level.scale / 2, BufferedImage.SCALE_DEFAULT),
				(int) (pos.getX() - level.scale / 4), (int) (pos.getY() - level.scale / 4), null);
	}

	/**
	 * Update Unit
	 */
	public void update() {
		this.pos = path.getPositionAtLength(getLifeTime() * speed / 100);
		if ((getLifeTime() * speed / 100) >= path.getLength()) {
			this.explode();
		}
	}

	/**
	 * Get the lifetime of this unit (milliseconds)
	 */
	public long getLifeTime() {
		return System.currentTimeMillis() - this.CreationTime;
	}

}
