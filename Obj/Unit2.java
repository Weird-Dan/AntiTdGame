package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class Unit2 extends Unit {
	public Unit2(Level lvl){
		level = lvl;
		setSpeed(4);
		health = 100;
		canShoot = true;
		path = level.path;
		setRange(2);
		damage = 1;
		laserColor = new Color(255, 0, 0, 32);
		fireRate = 15;
		setSprite(ImgOperator.ReadDefaultScaledImage("src/game/AntiTdGame/res/unit.png", (int)level.scale, (int)level.scale));
	}
}