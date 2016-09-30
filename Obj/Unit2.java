package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class Unit2 extends Unit {
	public Unit2(Level lvl){
		level = lvl;
		speed = 4;
		health = 100;
		canShoot = true;
		path = level.path;
		Range = 5;
		damage = 2;
		laserColor = Color.red;
		setSprite(Read.readImage("src/game/AntiTdGame/res/unit.png"));
	}
}