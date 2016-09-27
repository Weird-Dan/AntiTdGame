package game.AntiTdGame;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.Main;
import engine.Render.Camera;
import engine.Render.Renderable;
import game.AntiTdGame.Debug.PathDrawer;
import game.AntiTdGame.Obj.Unit;
import game.AntiTdGame.Util.Path;
import engine.Common.Vector;

public class Level implements Camera {

	private CopyOnWriteArrayList<Renderable> camera = new CopyOnWriteArrayList<Renderable>();
	public Path path;

	Main mn;

	/**
	 * Initialize Camera
	 */
	@Override
	public void LoadClass(Main fm) {
		this.mn = fm;
		// add objects to camera mby
		// TODO Auto-generated method stub
		ArrayList<Vector> nodes = new ArrayList<Vector>();
		nodes.add(new Vector(200,200));
		nodes.add(new Vector(250,200));
		nodes.add(new Vector(250,300));
		nodes.add(new Vector(400,300));
		nodes.add(new Vector(400,200));
		nodes.add(new Vector(500,200));
		path = new Path(nodes);
		
		camera.add(new PathDrawer(path));
	}

	/**
	 * Return ArrayList of Renderable objects, used in Main, This is nessisary.
	 */
	@Override
	public CopyOnWriteArrayList<Renderable> getRenderables() {
		return this.camera;
	}

	/**
	 * Update Camera
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	/**
	 * Run before Terminating Camera
	 */
	@Override
	public void end() {
		// TODO Auto-generated method stub

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

