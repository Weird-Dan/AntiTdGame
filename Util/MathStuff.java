package game.AntiTdGame.Util;

import engine.Common.Vector;

public abstract class MathStuff {
	
	public static double distance(Vector v1, Vector v2){
		double a = (v1.getX() - v2.getX());
		double b = (v1.getY() - v2.getY());
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		return c;
	}
}