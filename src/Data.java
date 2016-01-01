import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Data extends JPanel implements MouseMotionListener, MouseListener, ActionListener, KeyListener {

	Timer t = new Timer(5, this);
	MakeCube sqr = new MakeCube();
	Space3D area = new Space3D();
	Ellipse2D ell;

	public Data() {
		t.start();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		area.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawString("x: " + xpoint, 20, 45);
		g.drawString("y: " + ypoint, 20, 70);
		sqr.paintComponent(g);
		setBackground(null);
		colorPixel(g);
		TargetClick(g);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		sqr.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		sqr.keyReleased(e);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		sqr.actionPerformed(e);
	}

	double xpoint, ypoint, xpos, ypos;

	public void colorPixel(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect((int) xpoint, (int) ypoint, 0, 0);
	}

	public void TargetClick(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2 = (Graphics2D) g;
		ell = new Ellipse2D.Double(xpos - 5, ypos - 5, 10, 10);
		g2.draw(ell);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		xpos = e.getX();
		ypos = e.getY();
		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());*/
		xpoint = e.getX();
		ypoint = e.getY();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		xpos = point.getX();
		ypos = point.getY();

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
