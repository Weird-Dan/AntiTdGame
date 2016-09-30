package game.AntiTdGame.Obj;

import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class Unit1 extends Unit {
	public Unit1(Level lvl){
		level = lvl;
		setSpeed(7);
		SH = 75;
		health = SH;
		canShoot = false;
		path = level.path;
		setSprite(Read.readImage("src/game/AntiTdGame/res/unit1.png"));
	}
}