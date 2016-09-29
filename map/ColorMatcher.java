package game.AntiTdGame.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import engine.ReadWrite.Read;

public class ColorMatcher {

	HashMap<Integer, String> csmap = new HashMap<>();
	HashMap<String, BufferedImage> sbmap = new HashMap<>();

	/**
	 * init colorMatcher
	 */
	public ColorMatcher() {
		// add coralate images
		csmap.put(-7389398, "src/game/AntiTdGame/res/Placable.png");
		csmap.put(-5197658, "src/game/AntiTdGame/res/walk.png");
		csmap.put(-14342875, "src/game/AntiTdGame/res/NoTile.png");
		csmap.put(-16711936, "src/game/AntiTdGame/res/Spawn.png");
		csmap.put(-16776961, "src/game/AntiTdGame/res/goal.png");
	}

	public BufferedImage getScaledImage(int i, int scale) {
		return toBufferedImage(getImage(i).getScaledInstance(scale, scale, BufferedImage.SCALE_DEFAULT));
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

	public static BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	/**
	 * Create tile from Integer-color-value
	 */
	public Tile getTile(int i) {
		Tile tile = new Tile();
		tile.img = getImage(i);
		tile.clr = getColor(i);
		return tile;
	}

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

	private class ttle extends Tile {
		public ttle(Color c, boolean walk, boolean place) {
			this.clr = c;
			this.walkable = walk;
			this.placeable = place;
		}
	}

}
