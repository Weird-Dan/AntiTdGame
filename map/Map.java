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

	double scale;

	Vector pos;

	int w, h;

	public Map(String mapPath) {
		this.mapPath = mapPath;
		generateMap();
	}

	public void generateMap() {
		BufferedImage tmp = Read.readImage(mapPath); // get image
		// get colorModels

		int clr;
		int red;
		int green;
		int blue;

		this.w = tmp.getWidth();
		this.h = tmp.getHeight();
		InitTileMap(w * h); // init tilemap
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				TileMap[x * y] = new Tile();

				clr = tmp.getRGB(x, y);
				red = (clr & 0x00ff0000) >> 16;
				green = (clr & 0x0000ff00) >> 8;
				blue = clr & 0x000000ff;
				TileMap[x * y].clr = new Color(red, green, blue);

			}
		}

	}

	protected void InitTileMap(int size) {
		TileMap = new Tile[size];
	}

	@Override
	public void paint(Graphics g) {
		int ox = (int) pos.getX(), oy = (int) pos.getY();
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				g.fillRect((int) (ox + (x * scale)), (int) (oy + (y * scale)), (int) scale, (int) scale);
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
