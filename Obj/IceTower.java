package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.Common.Vector;
import engine.ReadWrite.Read;
import game.AntiTdGame.Level;
import game.AntiTdGame.Obj.Unit;

public class IceTower extends Tower {
	
	public IceTower(Level lvl, Vector position){
		level = lvl;
		fireRate = 20;
		setRange(2);
		SH = 500;
		damage = 1;
		health = SH;
		setSprite(Read.readImage("src/game/AntiTdGame/res/IceTower.png"));
		this.pos = position;
		setLaserColor(new Color(0, 128, 255, 128));
	}
	
	public void shoot(){
		super.shoot();
		target.slowdown += 5; 
	}

}