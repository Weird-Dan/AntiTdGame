package game.AntiTdGame.Obj;

import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class Unit1 extends Unit {
	public Unit1(Level lvl){
		level = lvl;
		setSpeed(5);
		health = 100;
		canShoot = false;
		path = level.path;
		setSprite(Read.readImage("src/game/AntiTdGame/res/unit1.png"));
	}
}