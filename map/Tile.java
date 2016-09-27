package game.AntiTdGame.map;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Tile {
	
	BufferedImage img; // tile-image
	
	Color clr; // default draw/fill color
	
	boolean walkable; // is walkable by units
	
	boolean placeable; //is able to hold tower
	
	boolean occupied; // tower is placed
	
	
}
