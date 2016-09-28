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
		while(dist <= length && i < nodes.size()-1){
			x = nodes.get(i+1).getX();
			y = nodes.get(i+1).getY();
			deltaX = nodes.get(i+1).getX() - nodes.get(i).getX();
			deltaY = nodes.get(i+1).getY() - nodes.get(i).getY();
			dist += Math.abs(deltaX) + Math.abs(deltaY);
			i++;
		}
		
		if(deltaX < 0){
			x += dist - length;
		}
		else if(deltaX > 0){
			x -= dist - length;
		}
		if(deltaY < 0){
			y += dist - length;
		}
		else if(deltaY > 0){
			y -= dist - length;
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
	
	public double getLength(){
		double x = 0;
		double y = 0;
		double deltaX = 0;
		double deltaY = 0;
		double dist = 0;
		for(int i = 0; i < nodes.size() - 1; i++){
			x = nodes.get(i+1).getX();
			y = nodes.get(i+1).getY();
			deltaX = nodes.get(i+1).getX() - nodes.get(i).getX();
			deltaY = nodes.get(i+1).getY() - nodes.get(i).getY();
			dist += Math.abs(deltaX) + Math.abs(deltaY);
		}
		
		return dist;
	}
}