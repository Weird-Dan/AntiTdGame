package game.AntiTdGame.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import engine.Common.Vector;
import engine.ReadWrite.Read;
import engine.Render.Renderable;

public class Map implements Renderable {

	Tile[] TileMap;

	private final String mapPath;

	double scale = 1.0;

	Vector pos = new Vector(0, 0);

	int w, h, pixelbuffer = 1;

	public Map(String mapPath) {
		this.mapPath = mapPath;
		generateMap(this.mapPath);
	}

	public void generateMap(String MapPath) {
		BufferedImage tmp = Read.readImage(MapPath); // get image

		if (tmp == null) {
			System.out.println("Could Not Load Map!");
			return;
		}

		int clr;
		int red;
		int green;
		int blue;
		int alpha;

		this.w = tmp.getWidth();
		this.h = tmp.getHeight();
		TileMap = new Tile[w * h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				TileMap[x * h + y] = new Tile();
				//tile = ColorMatcher.getTile(tmp.getRGB);
				clr = tmp.getRGB(x, y);
				red = (clr & 0x00ff0000) >> 16;
				green = (clr & 0x0000ff00) >> 8;
				blue = clr & 0x000000ff;
				alpha = (clr & 0xff000000) >>> 24;
				TileMap[x * h + y].clr = new Color(red, green, blue, alpha);
				if (red==143 && green == 63 && blue == 42) {
					TileMap[x * h + y].img = Read.readImage("Tower1.png");
					System.out.println("Integer-color-value: "+clr);
				}
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
					g.drawImage(img.getScaledInstance((int) scale, (int) scale, BufferedImage.SCALE_DEFAULT),
							(int) (ox + (x * scale)), (int) (oy + (y * scale)), null);
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

	public String getMapPath() {
		return this.mapPath;
	}

	public void setScale(double s) {
		this.scale = s;
	}

	public double getScale() {
		return this.scale;
	}

}
