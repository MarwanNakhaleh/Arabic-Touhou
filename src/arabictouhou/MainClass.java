package arabictouhou;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import arabictouhou.framework.Animation;

public class MainClass extends Applet implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private Aisha aisha;
	private Rachel rachel;
	private Image image, aisha1, aisha2, aisha3, aisha4, aisha5, aishaCurrent, enemy,
			background, aishaBullet;
	private Graphics second;
	private URL base;
	private static Background bg1, bg2;
	private Animation aisha_animate;

	@Override
	public void init() {

		setSize(480, 700);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		// I still need a better title, I think
		frame.setTitle("Devil's Cabana Girls: Army of Sluts");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// lel looks like ur fucked m9
		}
		// images to animate Aisha
		aisha1 = getImage(base, "data/Aisha_sprite0.png");
		aisha2 = getImage(base, "data/Aisha_sprite1.png");
		aisha3 = getImage(base, "data/Aisha_sprite2.png");
		aisha4 = getImage(base, "data/Aisha_sprite3.png");
		aisha5 = getImage(base, "data/Aisha_sprite4.png");
		//let's get animated!
		aisha_animate = new Animation();
		aisha_animate.addFrame(aisha1, 50);
		aisha_animate.addFrame(aisha2, 50);
		aisha_animate.addFrame(aisha3, 50);
		aisha_animate.addFrame(aisha4, 50);
		aisha_animate.addFrame(aisha5, 50);
		// everything else
		enemy = getImage(base, "data/Rachel_sprite0.png");
		background = getImage(base, "data/background.png");
		aishaBullet = getImage(base, "data/Aisha_bullet.png");
		//so the animation actually works
		aishaCurrent = aisha_animate.getImage();
	}

	@Override
	public void start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(0, -2160);
		aisha = new Aisha();
		rachel = new Rachel(240, 75);
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
			// update Aisha
			aisha.update();
			aishaCurrent = aisha_animate.getImage();
			// handle her bullets
			ArrayList<Bullet> aishaBullets = aisha.getBullets();
			for (int i = 0; i < aishaBullets.size(); i++) {
				Bullet b = (Bullet) aishaBullets.get(i);
				if (b.isVisible()) {
					b.update();
				} else {
					aishaBullets.remove(b);
				}
			}
			// update Rachel
			rachel.update();
			// handle her bullets
			ArrayList<Bullet> rachelBullets = rachel.getBullets();
			for (int i = 0; i < rachelBullets.size(); i++) {
				Bullet b = (Bullet) rachelBullets.get(i);
				if (b.isVisible()) {
					b.update();
				} else {
					rachelBullets.remove(b);
				}
			}
			bg1.update();
			bg2.update();
			aisha_animate.update(10);
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
		// background goes on bottom
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
		// then Rachel's bullets
		ArrayList<Bullet> rachelBullets = rachel.getBullets();
		for (int i = 0; i < rachelBullets.size(); i++) {
			Bullet b = (Bullet) rachelBullets.get(i);
			g.setColor(Color.decode("AAAAAA"));
			g.fillOval(b.getX(), b.getY(), 10, 10);
		}
		// then Aisha's bullets
		ArrayList<Bullet> aishaBullets = aisha.getBullets();
		for (int i = 0; i < aishaBullets.size(); i++) {
			Bullet b = (Bullet) aishaBullets.get(i);
			g.drawImage(aishaBullet, b.getX(), b.getY(), this);
		}
		// then Aisha
		g.drawImage(aisha_animate.getImage(), aisha.getCenterX() - 30,
				aisha.getCenterY() - 60, this);
		// then Rachel
		g.drawImage(enemy, rachel.getCenterX() - 50, rachel.getCenterY() - 68,
				this);

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
			aisha.fire();
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