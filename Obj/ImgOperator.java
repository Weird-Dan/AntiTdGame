package game.AntiTdGame.Obj;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import engine.ReadWrite.Read;

public abstract class ImgOperator {

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

	public static BufferedImage getScaledImage(BufferedImage img, int scalex, int scaley, int scaleOp) {
		return toBufferedImage(img.getScaledInstance(scalex, scaley, scaleOp));
	}

	public static BufferedImage getDefaultScaledImage(BufferedImage img, int scalex, int scaley) {
		return getScaledImage(img, scalex, scaley, BufferedImage.SCALE_DEFAULT);
	}

	public static BufferedImage ReadDefaultScaledImage(String file, int scalex, int scaley) {
		return getDefaultScaledImage(Read.readImage(file), scalex, scaley);
	}

}
