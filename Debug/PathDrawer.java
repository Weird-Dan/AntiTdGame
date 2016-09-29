package game.AntiTdGame.Debug;

import java.awt.Color;
import java.awt.Graphics;

import engine.Common.Vector;
import engine.Render.Renderable;
import game.AntiTdGame.Level;
import game.AntiTdGame.Util.Path;

public class PathDrawer implements Renderable {
	double length = 0;
	Level level;
	
	Path path;
	public PathDrawer(Path path, Level level){
		this.path = path;
		this.level = level;
	}

	@Override
	public void paint(Graphics g) {
		if(!level.debug)
			return;
		g.setColor(Color.cyan);
		for(int i = 0; i <  path.getNodes().size() - 1; i++){
			g.drawLine((int)path.getNode(i).getX(), (int)path.getNode(i).getY(), (int)path.getNode(i+1).getX(), (int)path.getNode(i+1).getY());
		}
		Vector v = path.getPositionAtLength((int)length);
		//g.drawOval((int)v.getX()-16, (int)v.getY()-16, 32, 32);
		//g.drawString("("+v.getX()+", "+v.getY()+") " + length, 16, 16);
	}

	@Override
	public void update() {
		length+= 2;
		if(length >= path.getLength()){
			length = 0;
		}
	}

}