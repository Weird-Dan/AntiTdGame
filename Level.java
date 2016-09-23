package game.AntiTdGame;

import java.util.concurrent.CopyOnWriteArrayList;

import engine.Main;
import engine.Render.Camera;
import engine.Render.Renderable;
import game.AntiTdGame.Obj.Unit;

public class Level implements Camera {

	private CopyOnWriteArrayList<Renderable> camera = new CopyOnWriteArrayList<Renderable>();

	Main mn;

	/**
	 * Initialize Camera
	 */
	public void LoadClass(Main fm) {
		this.mn = fm;
		// add objects to camera mby
	}

	/**
	 * Return ArrayList of Renderable objects, used in Main, This is nessisary.
	 */
	public CopyOnWriteArrayList<Renderable> getRenderables() {
		return this.camera;
	}

	/**
	 * Update Camera
	 */
	public void tick() {

	}

	/**
	 * Run before Terminating Camera
	 */
	public void end() {

		// add temp score to total score.
	}

	/**
	 * return the unit closest to the given x,y coordinates, ignoring all the
	 * units on the ignore array
	 */
	public Unit getClosestUnit(float x, float y, Unit[] ingore) {
		return null;
	}

	/**
	 * return the unit closest to the given x, y coordinates
	 * */
	public Unit getClosestUnit(float x, float y) {
		return null;
	}

}
