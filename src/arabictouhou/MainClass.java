package arabictouhou;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class MainClass extends Applet implements Runnable, KeyListener {
	// Aisha is our hero
	private Aisha aisha;
	// background and Aisha's sprite
	private Image image, character;
	private URL base;
	private Graphics second;
	//we need two backgrounds for smooth looping
	private Background bg1, bg2;

	// build the applet frame
	@Override
	public void init() {
		setSize(480, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Arabic Touhou: Witch Illusion?");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// lel ur fucked m9
		}
		character = getImage(base, "data/character.png");
	}

	// create a thread that refreshes once every 1/60 seconds
	@Override
	public void start() {
		bg1 = new Background(0,0);
		bg2 = new Background(0,2160);
		aisha = new Aisha();
		Thread thread = new Thread();
		thread.start();
	}

	// stop and destroy might be useful later
	@Override
	public void stop() {

	}

	@Override
	public void destroy() {

	}

	// draw everything on the screen
	@Override
	public void paint(Graphics g) {
		g.drawImage(character, aisha.getCenterX() - 40,
				aisha.getCenterY() - 60, this);
	}

	// run the thread once every 1/60 seconds
	public void run() {
		while (true) {
			aisha.update();
			bg1.update();
			bg2.update();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// repaint everything with each frame... I feel like there should be a more
	// efficient way to do this
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			aisha.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			aisha.moveDown();
			break;
		case KeyEvent.VK_LEFT:
			aisha.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			aisha.moveRight();
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
			aisha.stop();
			break;
		case KeyEvent.VK_DOWN:
			aisha.stop();
			break;
		case KeyEvent.VK_LEFT:
			aisha.stop();
			break;
		case KeyEvent.VK_RIGHT:
			aisha.stop();
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
