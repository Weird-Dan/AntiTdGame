package game.AntiTdGame.Obj;

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
