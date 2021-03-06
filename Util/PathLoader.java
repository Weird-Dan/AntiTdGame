package game.AntiTdGame.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import engine.Common.Vector;

public abstract class PathLoader {


	public static Path LoadPath (String path, double scale) {
		ArrayList<Vector> nodes = new ArrayList<Vector>();
		BufferedReader br = null;

		try {
			
			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));
			System.out.println("Reading '"+path+"'!");
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				String[] coords = sCurrentLine.split(",");
				double x = Double.parseDouble(coords[0]) * scale + scale / 2;
				double y = Double.parseDouble(coords[1]) * scale + scale / 2;
				nodes.add(new Vector(x, y));
			}
			
			return new Path(nodes);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing File!");
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return null;

	}
}