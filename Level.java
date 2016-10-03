package game.AntiTdGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.sun.glass.events.KeyEvent;

import engine.Main;
import engine.Common.Vector;
import engine.Render.Camera;
import engine.Render.Renderable;
import game.AntiTdGame.Debug.PathDrawer;
import game.AntiTdGame.Obj.*;
import game.AntiTdGame.Util.Path;
import game.AntiTdGame.Util.PathLoader;
import game.AntiTdGame.map.Map;;

public class Level implements Camera {

	private CopyOnWriteArrayList<Renderable> camera = new CopyOnWriteArrayList<Renderable>();
	public Path path;

	Main mn;

	Map cmap;

	String clevel = "src/game/AntiTdGame/res/Map1.png";
	public boolean debug = false;

	public double scale = 48;

	int placerate = 60 * 10;
	int upt = 0;
	int sc = 10;

	Random r = new Random();

	ArrayList<Unit> units = new ArrayList<Unit>();
	ArrayList<Tower> towers = new ArrayList<Tower>();

	/**
	 * Initialize Camera
	 */
	@Override
	public void LoadClass(Main fm) {
		this.mn = fm;
		// if (clevel==null) this.clevel = "game/AntiTdGame/res/Map1.png";
		// add objects to camera mby
		// TODO Auto-generated method stub

		scale = mn.getHEIGHT() / 16;

		cmap = new Map(this.clevel, scale);
		cmap.setScale(scale);
		mn.setScale(1);
		camera.add(this.cmap);
		mn.setTitle("AntiTdGame");

		path = PathLoader.LoadPath("src/game/AntiTdGame/res/Map1.path", cmap.getScale());

		camera.add(new PathDrawer(path, this));

		/*
		 * t = new IceTower(this, new Vector(3 * scale + scale / 2, 4 * scale +
		 * scale / 2)); SpawnTower(t);
		 */

		for (int i = 0; i < sc; i++) {
			RandomSpawnTower();
		}

		Unit u = new Unit1(this);
		SpawnUnit(u);
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
		// cmap.setScale(cmap.getScale());
		if (mn.isPressed(KeyEvent.VK_S)) {
			Unit u2 = new Unit2(this);
			SpawnUnit(u2);
		}

		if (upt >= placerate) {
			upt = 0;
			RandomSpawnTower();
		} else {
			upt++;
		}

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
	public Unit getClosestUnit(float x, float y, Unit[] ignore) {
		return null;
	}

	/**
	 * return the unit closest to the given x, y coordinates
	 */
	public Unit getClosestUnit(float x, float y) {
		return null;
	}

	public void addToLevel(Renderable r) {
		camera.add(r);
	}

	public void removeFromLevel(Renderable r) {
		camera.remove(r);
	}

	public void SpawnUnit(Unit u) {
		addToLevel(u);
		units.add(u);
	}

	public void KillUnit(Unit u) {
		removeFromLevel(u);
		units.remove(u);
	}

	/**
	 * @return the units
	 */
	public ArrayList<Unit> getUnits() {
		return units;
	}

	public void SpawnRandomTower(Tower t) {
		ArrayList<Pos> ps = cmap.getPlacable();
		Pos p = ps.get(r.nextInt(ps.size()));
		cmap.occupy(p.getX(), p.getY());
		t.setPos(new Vector(p.getX() * scale + (scale / 2), p.getY() * scale + (scale / 2)));
		SpawnTower(t);
	}

	public void RandomSpawnTower() {
		int i = r.nextInt(3);
		if (i == 1) {
			SpawnRandomTower(new IceTower(this, new Vector(0, 0)));
		} else if (i == 2) {
			SpawnRandomTower(new FireTower(this, new Vector(0, 0)));
		}else {
			SpawnRandomTower(new BasicTower(this, new Vector(0, 0)));
		}
	}

	public void SpawnTower(Tower t) {
		addToLevel(t);
		towers.add(t);
	}

	public void KillTower(Tower t) {
		removeFromLevel(t);
		towers.remove(t);
		Vector p = t.getPos();

		int x = (int) ((p.getX() / scale) - (scale / 2)), y = (int) ((p.getX() / scale) - (scale / 2));
		System.out.println("remove x:"+x+" y:"+y);
		cmap.addPlacable(x, y);
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public int getMapWidth() {
		return this.cmap.getWidth();
	}

	public int getMapHeight() {
		return this.cmap.getHeight();
	}
}