package game.AntiTdGame.map;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import engine.ReadWrite.Read;
import game.AntiTdGame.Obj.ImgOperator;

public class ColorMatcher {

	HashMap<Integer, String> csmap = new HashMap<>();
	HashMap<String, BufferedImage> sbmap = new HashMap<>();
	HashMap<Integer, Ttile> stmap = new HashMap<>();

	/**
	 * init colorMatcher
	 */
	public ColorMatcher() {
		// add coralate images
		csmap.put(-7389398, "src/game/AntiTdGame/res/Placable.png");
		stmap.put(-7389398, new Ttile(false, true));
		
		csmap.put(-5197658, "src/game/AntiTdGame/res/walk.png");
		stmap.put(-5197658, new Ttile(true, false));
		
		csmap.put(-14342875, "src/game/AntiTdGame/res/NoTile.png");
		stmap.put(-14342875, new Ttile(false, false));
		
		csmap.put(-16711936, "src/game/AntiTdGame/res/Spawn.png");
		stmap.put(-16711936, new Ttile(true, false));
		
		csmap.put(-16776961, "src/game/AntiTdGame/res/goal.png");
		stmap.put(-16776961, new Ttile(true, false));

	}

	public BufferedImage getScaledImage(int i, int scale) {
		return ImgOperator.getDefaultScaledImage(getImage(i), scale, scale);
	}

	/**
	 * get image from Integer-color-value
	 */
	public BufferedImage getImage(int i) {
		if (csmap.containsKey(i)) {
			String s = csmap.get(i);
			if (!sbmap.containsKey(s)) {
				try { // try loading texture;
					sbmap.put(s, Read.readImage(s));
				} catch (Exception e) {
					csmap.remove(i); // the image does not load, remove from map
					return null;
				}
			}
			return sbmap.get(s);
		}
		return null;
	}

	

	/**
	 * Create tile from Integer-color-value
	 */
	/*
	 * public Tile getTile(int i) { Tile tile = new Tile(); tile.img =
	 * getImage(i); tile.clr = getColor(i); return tile; }
	 */

	/**
	 * convert integer-color to java.awt color
	 */
	public Color getColor(int i) {
		int red = (i & 0x00ff0000) >> 16;
		int green = (i & 0x0000ff00) >> 8;
		int blue = i & 0x000000ff;
		int alpha = (i & 0xff000000) >>> 24;
		return new Color(red, green, blue, alpha);
	}

	/**
	 * create tile from Integer-color-value
	 */
	public Tile getTile(int i, int scale) {
		if (csmap.containsKey(i)) {
			String s = csmap.get(i);
			Ttile tpt = stmap.get(i);
			tpt.setColor(getColor(i));
			tpt.setImage(getScaledImage(i, scale));

			return tpt;
		}
		return null;

	}

	private class Ttile extends Tile {
		public Ttile(boolean walk, boolean place) {
			this.walkable = walk;
			this.placeable = place;
		}

		public void setImage(BufferedImage img) {
			this.img = img;
		}

		public void setColor(Color c) {
			this.clr = c;
		}

	}

}
