package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class TankUnit extends Unit {
	public TankUnit(Level lvl){
		level = lvl;
		setSpeed(2);
		SH = 250;
		health = SH;
		canShoot = true;
		fireRate = 120;
		setRange(4);
		damage = 20;
		laserColor = new Color(255,255,0,128);
		path = level.path;
		setSprite(Read.readImage("src/game/AntiTdGame/res/unit1.png"));
	}
}