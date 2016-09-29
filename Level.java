package game.AntiTdGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import engine.Main;
import engine.Render.Camera;
import engine.Render.Renderable;
import game.AntiTdGame.Debug.PathDrawer;
import game.AntiTdGame.Obj.Tower;
import game.AntiTdGame.Obj.Unit;
import game.AntiTdGame.Util.Path;
import engine.Common.Vector;
import engine.ReadWrite.Read;
import game.AntiTdGame.map.Map;
import game.AntiTdGame.Util.PathLoader;;

public class Level implements Camera {

	private CopyOnWriteArrayList<Renderable> camera = new CopyOnWriteArrayList<Renderable>();
	public Path path;

	Main mn;

	Map cmap;

	String clevel = "src/game/AntiTdGame/res/Map1.png";
	
	public double scale = 32;
	
	PathLoader pl = new PathLoader();
	ArrayList<Unit> units = new ArrayList<Unit>();

	/**
	 * Initialize Camera
	 */
	@Override
	public void LoadClass(Main fm) {
		this.mn = fm;
		// if (clevel==null) this.clevel = "game/AntiTdGame/res/Map1.png";
		// add objects to camera mby
		// TODO Auto-generated method stub

		cmap = new Map(this.clevel);
		cmap.setScale(scale);
		camera.add(this.cmap);
		mn.setTitle("AntiTdGame");
		
		path = pl.LoadPath("src/game/AntiTdGame/res/Map1.path", cmap.getScale());

		//camera.add(new PathDrawer(path));
		
		Unit u = new Unit();
		u.path = path;
		u.setLevel(this);
		u.setSprite(Read.readImage("src/game/AntiTdGame/res/unit.png"));
		SpawnUnit(u);
		
		Tower t = new Tower();
		t.setLevel(this);
		t.setRange(3);
		t.setSprite(Read.readImage("src/game/AntiTdGame/res/Tower1.png"));
		t.setPos(new Vector(9 * scale + scale / 2, 2 * scale + scale / 2));
		t.setLaserColor(Color.green);
		camera.add(t);
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
		//cmap.setScale(cmap.getScale());
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
	
	public void addToLevel(Renderable r){
		camera.add(r);
	}
	
	public void removeFromLevel(Renderable r){
		camera.remove(r);
	}
	
	public void SpawnUnit(Unit u){
		addToLevel(u);
		units.add(u);
	}
	
	public void KillUnit(Unit u){
		removeFromLevel(u);
		units.remove(u);
	}

	/**
	 * @return the units
	 */
	public ArrayList<Unit> getUnits() {
		return units;
	}
}