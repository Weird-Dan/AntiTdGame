package game.AntiTdGame.Obj;

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
	
	void explode(){
		level.KillUnit(this);
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed * level.scale / 32;
	}

}
