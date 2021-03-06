package game.AntiTdGame.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import engine.Common.Vector;
import engine.ReadWrite.Read;
import engine.Render.Renderable;
import game.AntiTdGame.Obj.Pos;

public class Map implements Renderable {

	Tile[] TileMap;

	ArrayList<Pos> placeble = new ArrayList<Pos>();

	private final String mapPath;

	double scale = 1.0;

	Vector pos = new Vector(0, 0);

	int w, h, pixelbuffer = 1;

	ColorMatcher cm = new ColorMatcher();

	public Map(String mapPath, double scale) {
		this.mapPath = mapPath;
		this.scale = scale;
		generateMap(this.mapPath);
	}

	public void generateMap(String MapPath) {
		BufferedImage tmp = Read.readImage(MapPath); // get image

		if (tmp == null) {
			System.out.println("Could Not Load Map!");
			return;
		}

		int clr;

		this.w = tmp.getWidth();
		this.h = tmp.getHeight();
		TileMap = new Tile[w * h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {

				// tile = ColorMatcher.getTile(tmp.getRGB);
				clr = tmp.getRGB(x, y);
				TileMap[x * h + y] = cm.getTile(clr, (int) scale);

				if (TileMap[x * h + y].placeable) {
					placeble.add(new Pos(x, y));
				}

				/*
				 * red = (clr & 0x00ff0000) >> 16; green = (clr & 0x0000ff00) >>
				 * 8; blue = clr & 0x000000ff; alpha = (clr & 0xff000000) >>>
				 * 24; TileMap[x * h + y].clr = new Color(red, green, blue,
				 * alpha); TileMap[x * h + y].img = cm.getScaledImage(clr, (int)
				 * scale);
				 */

				/*
				 * System.out.println("Integer-color-value: " + clr + " at x:" +
				 * x + " y:" + y); if (red == 143 && green == 63 && blue == 42)
				 * { TileMap[x * h + y].img =
				 * Read.readImage("src/game/AntiTdGame/res/Placable.png");
				 * System.out.println("Integer-color-value: " + clr); }
				 */
			}
		}

	}

	@Override
	public void paint(Graphics g) {
		int ox = (int) pos.getX(), oy = (int) pos.getY();
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				BufferedImage img;
				if (TileMap[x * h + y].img != null) {
					img = TileMap[x * h + y].img;
					g.drawImage(img, (int) (ox + (x * scale)), (int) (oy + (y * scale)), null);
				} else {
					g.setColor(TileMap[x * h + y].clr);
					g.fillRect((int) (ox + (x * scale)), (int) (oy + (y * scale)), (int) scale + pixelbuffer,
							(int) scale + pixelbuffer);
				}
			}
		}
	}

	@Override
	public void update() {

	}

	public int getWidth() {
		return this.w;
	}

	public int getHeight() {
		return this.h;
	}

	public String getMapPath() {
		return this.mapPath;
	}

	public void setScale(double s) {
		this.scale = s;
	}

	public double getScale() {
		return this.scale;
	}

	public ArrayList<Pos> getPlacable() {
		return this.placeble;
	}

	public void addPlacable(int x, int y) {
		if (TileMap[x * h + y].placeable)
			this.placeble.add(new Pos(x, y));
	}

	public void occupy(int x, int y) {
		ArrayList<Pos> pt = new ArrayList<Pos>();
		for (Pos p : this.placeble) {
			if (p.getX() == x && p.getY() == y)
				pt.add(p);
		}
		for (Pos p : pt) {
			this.placeble.remove(p);
		}
	}

}
