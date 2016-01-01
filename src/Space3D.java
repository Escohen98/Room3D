import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Space3D extends JPanel {
	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	ArrayList<Polygon> poly = new ArrayList<Polygon>();
	ArrayList<String> polyNames = new ArrayList<String>();
	Line[][] floorGrid;
	Color[] colors;
	Image floor;
	
	int w = (int) size.getWidth();
	int h = (int) size.getHeight();
	
	//Point Order: Top, Bottom, Center
	int[] xtriLeft = { 0, 0, w / 2 };
	int[] xtriRight = { w, w, w / 2 };
	int[] ytri = { 0, h, w / 2 };

	//Point Order: Bottom Left, Bottom Right, Top Right, Top Left
	int[] xWallLeft = { 0, 0, w / 6, w / 6 };
	int[] yWallLeft = { 0, h, 5 * h / 6, h / 6 };

	//Point Order: Top Right, Bottom Right, Bottom Left, Top Left
	int[] xWallRight = { w, w, 5 * w / 6, 5 * w / 6 };
	int[] yWallRight = { 0, h, 5 * h / 6, h / 6 };

	//Point Order: Bottom Left, Bottom Right, Top Right, Top Left
	int[] xFloor = { 0, w, 5 * w / 6, w / 6 };
	int[] yFloor = { h, h, 5 * h / 6, 5 * h / 6 };

	//Point Order: Bottom Left, Bottom Right, Top Right, Top Left
	int[] xCeil = { 0, w, 5 * w / 6, w / 6 };
	int[] yCeil = { 0, 0, h / 6, h / 6 };

	//Point Order: Bottom Left, Bottom Right, Top Right, Top Left
	int[] xWallBack = { w / 6, 5 * w / 6, 5 * w / 6, w / 6 };
	int[] yWallBack = { 5 * h / 6, 5 * h / 6, h / 6, h / 6 };

	public Space3D() {
		addPolygon(xWallLeft, yWallLeft, "LeftWall");
		addPolygon(xWallRight, yWallRight, "RightWall");
		addPolygon(xFloor, yFloor, "Floor");
		addPolygon(xCeil, yCeil, "Ceiling");
		addPolygon(xWallBack, yWallBack, "BackWall");
		colors = new Color[poly.size()];
		colors[0] = Color.BLACK;
		colors[1] = Color.BLACK;
		colors[2] = Color.BLUE;
		colors[3] = Color.YELLOW;
		colors[4] = Color.BLACK;
	}
	
	public Image getFloor() {
		try {
			floor = new ImageIcon(ImageIO.read(new File("src\\grid_floor.png"))).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return floor;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		for (Polygon p : poly) {
			g.setColor(Color.DARK_GRAY);
			g.drawPolygon(p);
			g.setColor(makeColor(poly.indexOf(p)));
			g.fillPolygon(p);
		}
		

		
			/*Rectangle f = poly.get(2).getBounds();
			g.setClip(poly.get(2));
			g.drawImage(getFloor(), 0,750,1600,150, null);
			g.setClip(null);*/
	
		
	}

	public void addPolygon(int[] x, int[] y, String name) {
		poly.add(new Polygon(x, y, x.length));
		polyNames.add(name);
	}
	
	public Color makeColor(int indx) {
		return colors[indx];
	}
	
	public void addFloorGrid() {
		int x1, x2, y1, y2;
	}
}
