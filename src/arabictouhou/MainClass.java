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

	private Aisha aisha;
	private Image image, character, currentSprite, background;
	private Graphics second;
	private URL base;
	private static Background bg1, bg2;

	@Override
	public void init() {

		setSize(480, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Q-Bot Alpha");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Image Setups
		character = getImage(base, "data/Aisha_sprite2.png");
		currentSprite = character;
		background = getImage(base, "data/background.png");
	}

	@Override
	public void start() {
		bg1 = new Background(0,0);
		bg2 = new Background(0,2160);
		aisha = new Aisha();
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
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

	@Override
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
	public void paint(Graphics g) {
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
		g.drawImage(currentSprite, aisha.getCenterX() - 30, aisha.getCenterY() - 60, this);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			aisha.moveUp();
			aisha.setMovingUp(true);
			break;

		case KeyEvent.VK_DOWN:
			aisha.moveDown();
			aisha.setMovingDown(true);
			break;

		case KeyEvent.VK_LEFT:
			aisha.moveLeft();
			aisha.setMovingLeft(true);
			break;

		case KeyEvent.VK_RIGHT:
			aisha.moveRight();
			aisha.setMovingRight(true);
			break;

		case KeyEvent.VK_SPACE:
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			aisha.stopUp();
			break;

		case KeyEvent.VK_DOWN:
			aisha.stopDown();
			break;

		case KeyEvent.VK_LEFT:
			aisha.stopLeft();
			break;

		case KeyEvent.VK_RIGHT:
			aisha.stopRight();
			break;

		case KeyEvent.VK_SPACE:
			break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}


	

}