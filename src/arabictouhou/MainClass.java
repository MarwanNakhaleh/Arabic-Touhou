package arabictouhou;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MainClass extends Applet implements Runnable, KeyListener {

	@Override
	public void init() {
		setSize(480, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Arabic Touhou: Witch Illusion?");
	}

	@Override
	public void start() {
		Thread thread = new Thread();
		thread.start();
	}

	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			// move up
			break;
		case KeyEvent.VK_DOWN:
			// move down
			break;
		case KeyEvent.VK_LEFT:
			// move left
			break;
		case KeyEvent.VK_RIGHT:
			// move right
			break;
		case KeyEvent.VK_CONTROL:
			// fire
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			// stop moving up
			break;
		case KeyEvent.VK_DOWN:
			// stop moving down
			break;
		case KeyEvent.VK_LEFT:
			// stop moving left
			break;
		case KeyEvent.VK_RIGHT:
			// stop moving right
			break;
		case KeyEvent.VK_CONTROL:
			// stop firing
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// nothing goes here
	}

}
