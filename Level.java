package game.AntiTdGame;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.Main;
import engine.Render.Camera;
import engine.Render.Renderable;
import game.AntiTdGame.Debug.PathDrawer;
import game.AntiTdGame.Obj.Unit;
<<<<<<< HEAD
import game.AntiTdGame.Util.Path;
import engine.Common.Vector;
=======
import game.AntiTdGame.map.Map;
>>>>>>> origin/master

public class Level implements Camera {

	private CopyOnWriteArrayList<Renderable> camera = new CopyOnWriteArrayList<Renderable>();
	public Path path;

	Main mn;

	Map cmap;

	String clevel = "Map1.png";

	/**
	 * Initialize Camera
	 */
	@Override
	public void LoadClass(Main fm) {
		this.mn = fm;
		// if (clevel==null) this.clevel = "game/AntiTdGame/res/Map1.png";
		// add objects to camera mby
<<<<<<< HEAD
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
=======

		cmap = new Map(this.clevel);
		cmap.setScale(32.0);
		camera.add(this.cmap);

		mn.setTitle("AntiTdGame");

>>>>>>> origin/master
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
		if (false)
			end(); // change to : if (map completed)
	}

	/**
	 * Run before Terminating Camera
	 */
	@Override
	public void end() {
		// calculate score

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
	 */
	public Unit getClosestUnit(float x, float y) {
		return null;
	}

}
