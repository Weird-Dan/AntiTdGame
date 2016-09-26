package game.AntiTdGame.Obj;

import java.awt.Graphics;

import engine.Common.Vector;
import engine.Render.Renderable;


/**
 * @autor Weird-Dan
 * */
public class Actor implements Renderable {

	
	int health, damage;
	
	/**
	 * Position
	 * */
	Vector pos;
	
	double rotation;

	/**
	 * Draw to screen
	 * */
	public void paint(Graphics g) {
	}

	/**
	 * Update actor
	 * */
	public void update() {
	}

}
