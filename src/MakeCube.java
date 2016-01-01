import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MakeCube extends Cube implements ActionListener, KeyListener, MouseMotionListener, MouseListener {
	Timer t = new Timer(5, this);

	public MakeCube() {
		addKeyListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Times Roman", Font.PLAIN, 100));
		g.drawString("x: " + xmid, xdim / 3 + xdim / 16, ydim / 2 - 125);
		g.drawString("y: " + ymid, xdim / 3 + xdim / 16, ydim / 2 + 25);
		g.drawString("z: " + zmid, xdim / 3 + xdim / 16, ydim / 2 + 175);
		for (Polygon f : LeftCube) {
			g.setColor(Color.GREEN);
			g.fillPolygon(f);
			g.setColor(Color.RED);
			g.drawPolygon(f);

		}
	}

	public void left() {
		xvel = -10;
		x1 += 10;
		repaint();
	}

	public void right() {
		xvel = 10;
		x1 -= 10;
		repaint();
	}

	public void up() {
		zvel = -10;
		y1 -= 10;
		repaint();
	}

	public void down() {
		zvel = 10;
		y1 += 10;
		repaint();
	}

	public void forward() {
		yvel = 10;
	}

	public void backward() {
		yvel = -10;
	}

	public void stopX() {
		xvel = 0;
	}

	public void stopY() {
		yvel = 0;
	}

	public void stopZ() {
		zvel = 0;
	}

	public void setXVelocity() {
		x += xvel;

	}

	public void setYVelocity() {
		y += yvel;

	}

	public void setZVelocity() {
		z += zvel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		setXVelocity();
		setYVelocity();
		setZVelocity();
		//reinitializeFaces();
		//removeAllFaces();
		//addAllFaces();
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			backward();
			//System.out.printf("Backward\n",this);
		}
		if (code == KeyEvent.VK_DOWN) {
			forward();
			//System.out.printf("Forward\n", this);
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
			//System.out.printf("Left\n", this);
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
			//System.out.printf("Right\n", this);
		}
		if (code == KeyEvent.VK_SPACE) {
			up();
			//System.out.printf("Up\n", this);
		}
		if (code == KeyEvent.VK_SHIFT) {
			down();
			//System.out.printf("Down\n", this);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			stopY();
		}
		if (code == KeyEvent.VK_DOWN) {
			stopY();
		}
		if (code == KeyEvent.VK_LEFT) {
			stopX();
		}
		if (code == KeyEvent.VK_RIGHT) {
			stopX();
		}
		if (code == KeyEvent.VK_SPACE) {
			stopZ();
		}
		if (code == KeyEvent.VK_SHIFT) {
			stopZ();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			backward();
			//System.out.printf("Backward\n",this);
		}
		if (code == KeyEvent.VK_DOWN) {
			forward();
			//System.out.printf("Forward\n", this);
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
			//System.out.printf("Left\n", this);
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
			//System.out.printf("Right\n", this);
		}
		if (code == KeyEvent.VK_SPACE) {
			up();
			//System.out.printf("Up\n", this);
		}
		if (code == KeyEvent.VK_SHIFT) {
			down();
			//System.out.printf("Down\n", this);
		}

	}

	/*public static void main(String[] argv) {
	Cube cube = new Cube();
	JFrame frame = new JFrame("Size Tester");
	frame.setSize(xdim, ydim);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(cube);
	frame.setVisible(true);

	}*/
	@Override
	public void mouseDragged(MouseEvent e) {
		Rectangle eRect = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY());
		//if (e.getX() <= xFaceFront[2] && e.getX() >= xFaceTopLeft[3] && e.getY() <= yFaceTopLeft[3] && e.getY() >= yFaceFront[0]) {
		xcdim += e.getX() - xcoord;
		ycdim += e.getY() - ycoord;
		repaint();
		//	}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		xpos = e.getX();
		ypos = e.getY();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x1 = (xdim + x * 2) / 2;
		y1 = (ydim + z * 2) / 2 + 50;
		x2 = x1 + s + y;
		y2 = y1 - s + y;
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		xcoord = (int) point.getX();
		ycoord = (int) point.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
