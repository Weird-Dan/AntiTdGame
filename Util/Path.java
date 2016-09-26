package game.AntiTdGame.Util;

import java.util.ArrayList;

import engine.Common.Vector;

public class Path {
	ArrayList<Vector> nodes = new ArrayList<Vector>();
	
	public Path (ArrayList<Vector> nodes) {
		this.nodes = nodes;
	}
	
	public Vector getPositionAtLength(double length) {
		
		int i = 0;
		while(true){
			if(length < distance(nodes.get(i), nodes.get(i + 1))){
				break;
			}
			i++;
		}
		
		
		
		return new Vector(0, 0);
	}
	
	double distance(Vector v1, Vector v2){
		double a = (v1.getX() - v2.getY());
		double b = (v1.getY() - v2.getY());
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		return c;
	}
}