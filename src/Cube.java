import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Cube extends JPanel {
	GetSpace gs = new GetSpace();
	ArrayList<Polygon> LeftCube = new ArrayList();
	ArrayList<Polygon> RightCube = new ArrayList();
	static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	static int xdim = (int) size.getWidth();
	static int ydim = (int) size.getHeight();
	static int xcdim = xdim, ycdim = ydim;
	static int xcoord, ycoord;
	static int xpos, ypos;
	int x = 0, y = 0, z = 0;
	int xvel = 0, yvel = 0, zvel = 0;
	int s = 50 + y, m = Math.round(s * 46 / 325), x1 = (xcdim - s) / 2 - m + x, y1 = ycdim - s + z, x2 = x1 + s + y, y2 = y1 - s + y;
	//int x1 = (xdim + x * 2) / 2, y1 = (ydim + z * 2) / 2 + 50, x2 = x1 + s + y, y2 = y1 - s + y;
	int xmid = x1 + (s + m) / 2, ymid = y1 + m / 2, zmid = (y2 - y1) / 2 + y1;
	//Point Order: Bottom Left, Bottom Right, Top Right, Top Left
	int[] xFaceFront = { x1, x2, x2, x1 };
	int[] yFaceFront = { y1, y1, y2, y2 };

	int[] xFaceTopLeft = { x1, x2, x2 - m, x1 - m };
	int[] yFaceTopLeft = { y2, y2, y2 - m, y2 - m };

	int[] xFaceLeft = { x1 - m, x1, x1, x1 - m };
	int[] yFaceLeft = { y1 - m, y1, y2, y2 - m };

	int[] xFaceTopRight = { x1, x2, x2 + m, x1 + m };
	int[] yFaceTopRight = { y2, y2, y2 - m, y2 - m };

	int[] xFaceRight = { x2, x2 + m, x2 + m, x2 };
	int[] yFaceRight = { y1, y1 - m, y2 - m, y2 };

	public void reinitializeFaces() {
		xFaceFront[0] = x1;
		yFaceFront[0] = y1;
		xFaceFront[1] = x2;
		yFaceFront[1] = y1;
		xFaceFront[2] = x2;
		yFaceFront[2] = y2;
		xFaceFront[3] = x1;
		yFaceFront[3] = y2;

		xFaceTopLeft[0] = x1;
		yFaceTopLeft[0] = y2;
		xFaceTopLeft[1] = x2;
		yFaceTopLeft[1] = y2;
		xFaceTopLeft[2] = x2 - m;
		yFaceTopLeft[2] = y2 - m;
		xFaceTopLeft[3] = x1 - m;
		yFaceTopLeft[3] = y2 - m;

		xFaceLeft[0] = x1 - m;
		yFaceLeft[0] = y1 - m;
		xFaceLeft[1] = x1;
		yFaceLeft[1] = y1;
		xFaceLeft[2] = x1;
		yFaceLeft[2] = y2;
		xFaceLeft[3] = x1 - m;
		yFaceLeft[3] = y2 - m;

		xFaceTopRight[0] = x1;
		yFaceTopRight[0] = y2;
		xFaceTopRight[1] = x2;
		yFaceTopRight[1] = y2;
		xFaceTopRight[2] = x2 + m;
		yFaceTopRight[2] = y2 - m;
		xFaceTopRight[3] = x1 + m;
		yFaceTopRight[3] = y2 - m;

		xFaceRight[0] = x2;
		yFaceRight[0] = y1;
		xFaceRight[1] = x2 + m;
		yFaceRight[1] = y1 - m;
		xFaceRight[2] = x2 + m;
		yFaceRight[2] = y2 - m;
		xFaceRight[3] = x2;
		yFaceRight[3] = y2;
	}

	public Cube() {
		addAllFaces();
	}

	public void addLeftFace(int[] x, int[] y) {
		LeftCube.add(new Polygon(x, y, x.length));
	}

	public void addRightFace(int[] x, int[] y) {
		RightCube.add(new Polygon(x, y, x.length));
	}

	public void addAllFaces() {
		addLeftFace(xFaceFront, yFaceFront);
		addLeftFace(xFaceTopLeft, yFaceTopLeft);
		addLeftFace(xFaceLeft, yFaceLeft);

		addRightFace(xFaceFront, yFaceFront);
		addRightFace(xFaceTopRight, yFaceTopRight);
		addRightFace(xFaceRight, yFaceRight);
	}

	public void removeAllFaces() {
		for (int i = 0; i < LeftCube.size(); i++)
			LeftCube.remove(LeftCube.get(i));
		for (int i = 0; i < RightCube.size(); i++)
			RightCube.remove(RightCube.get(i));
	}

	/*public static void main(String[] argv) {
	Cube cube = new Cube();
	JFrame frame = new JFrame("Size Tester");
	frame.setSize(xdim, ydim);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(cube);
	frame.setVisible(true);
	*/
}
