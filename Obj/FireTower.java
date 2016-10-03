package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.Common.Vector;
import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class FireTower extends Tower {
	
	public FireTower(Level lvl, Vector position){
		level = lvl;
		fireRate = 1;
		setRange(1.5);
		SH = 1000;
		health = SH;
		damage = .5;
		setSprite(ImgOperator.ReadDefaultScaledImage("src/game/AntiTdGame/res/FireTower.png", (int)level.scale, (int)level.scale));
		this.pos = position;
		setLaserColor(new Color(255, 64, 0, 255));
	}

}