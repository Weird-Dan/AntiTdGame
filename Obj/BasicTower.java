package game.AntiTdGame.Obj;

import java.awt.Color;

import engine.Common.Vector;
import engine.ReadWrite.Read;
import game.AntiTdGame.Level;

public class BasicTower extends Tower {
	
	public BasicTower(Level lvl, Vector position){
		level = lvl;
		fireRate = 60;
		setRange(3.5);
		SH = 1000;
		health = SH;
		setSprite(ImgOperator.ReadDefaultScaledImage("src/game/AntiTdGame/res/Tower1.png", (int)level.scale, (int)level.scale));
		this.pos = position;
		setLaserColor(new Color(0, 255, 0, 128));
	}

}