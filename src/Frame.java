import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

import javax.swing.*;

public class Frame {
	static JFrame room = new JFrame();
	
	public static void ExitOnEscape() {
	    room.validate();
	    room.setVisible(true);

	    KeyAdapter listener = new KeyAdapter() {
	        @Override public void keyPressed(KeyEvent e) {
	        	if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
	            room.dispose();
	        }
	    };

	    room.addKeyListener(listener);
	}
	public static void main(String[] argv) {
		Data info = new Data();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		room.setExtendedState(JFrame.MAXIMIZED_BOTH);
		room.setUndecorated(true);
		ExitOnEscape();
		room.add(info);
		room.setVisible(true);

	}
}
