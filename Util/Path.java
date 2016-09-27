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
		double x = nodes.get(0).getX();
		double y = nodes.get(0).getY();
		double deltaX = 0;
		double deltaY = 0;
		double dist = 0;
		while(dist <= length && i < nodes.size() -1){
			dist += distance(nodes.get(i), nodes.get(i+1));
			x = nodes.get(i).getX();
			y = nodes.get(i).getY();
			deltaX = nodes.get(i).getX() - nodes.get(i+1).getX();
			deltaY = nodes.get(i).getY() - nodes.get(i+1).getY();
			i++;
		}
		
		if(deltaX < 0){
			y += dist - length;
		}
		else if(deltaX > 0){
			y -= dist - length;
		}
		if(deltaY < 0){
			x += dist - length;
		}
		else if(deltaY > 0){
			x -= dist - length;
		}
		
		return new Vector(x, y);
	}
	
	double distance(Vector v1, Vector v2){
		double a = (v1.getX() - v2.getY());
		double b = (v1.getY() - v2.getY());
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		return c;
	}
	
	public ArrayList<Vector> getNodes(){
		return nodes;
	}
	
	public Vector getNode(int index){
		return nodes.get(index);
	}
}