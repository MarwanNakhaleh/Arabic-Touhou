package arabictouhou;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
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
	public static Rachel rachel;
	private Image image, aisha1, aisha2, aisha3, aisha4, aisha5, rachel1,
			rachel2, rachel3, background, aishaBullet;
	private Graphics second;
	private URL base;
	private static Background bg1, bg2;
	private Animation aisha_animate, rachel_animate;
	//stats
	public static int score;
	private Font font = new Font(null, Font.BOLD, 15);

	@Override
	public void init() {

		setSize(800, 700);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		// I might actually be goo on the title now
		frame.setTitle("Tenth Circle of Hell");
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
		// images to animate Rachel
		rachel1 = getImage(base, "data/Rachel_sprite0.png");
		rachel2 = getImage(base, "data/Rachel_sprite1.png");
		rachel3 = getImage(base, "data/Rachel_sprite2.png");
		// let's get animated!
		aisha_animate = new Animation();
		aisha_animate.addFrame(aisha1, 100);
		aisha_animate.addFrame(aisha2, 100);
		aisha_animate.addFrame(aisha3, 100);
		aisha_animate.addFrame(aisha4, 100);
		aisha_animate.addFrame(aisha5, 100);
		aisha_animate.addFrame(aisha4, 100);
		aisha_animate.addFrame(aisha3, 100);
		aisha_animate.addFrame(aisha2, 100);
		rachel_animate = new Animation();
		rachel_animate.addFrame(rachel2, 100);
		rachel_animate.addFrame(rachel1, 100);
		rachel_animate.addFrame(rachel3, 100);
		rachel_animate.addFrame(rachel1, 100);
		// everything else
		background = getImage(base, "data/background.png");
		aishaBullet = getImage(base, "data/Aisha_bullet.png");
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
			// handle her bullets
			ArrayList<Bullet> aishaBullets = aisha.getBullets();
			for (int i = 0; i < aishaBullets.size(); i++) {
				Bullet b = (Bullet) aishaBullets.get(i);
				if (b.isVisible()) {
					b.update();
				} else {
					aishaBullets.remove(i);
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
			rachel_animate.update(10);
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
			g.fillOval(b.getX(), b.getY(), 15, 15);
		}
		// then Aisha's bullets
		ArrayList<Bullet> aishaBullets = aisha.getBullets();
		for (int i = 0; i < aishaBullets.size(); i++) {
			Bullet b = (Bullet) aishaBullets.get(i);
			g.drawImage(aishaBullet, b.getX(), b.getY(), this);
			// g.drawRect((int) b.getX(), (int) b.getX(), 15, 15);
		}
		// then Aisha
		g.drawImage(aisha_animate.getImage(), aisha.getCenterX() - 30,
				aisha.getCenterY() - 60, this);
		// draw rectangles for testing purposes
		/* g.drawRect((int) Aisha.rec.getX(), (int) Aisha.rec.getY(),
				(int) Aisha.rec.getWidth(), (int) Aisha.rec.getHeight()); */
		// then Rachel
		g.drawImage(rachel_animate.getImage(), rachel.getCenterX() - 50,
				rachel.getCenterY() - 68, this);
		// no circles shall be drawn
		/* g.drawRect((int) Rachel.recParent.getX(),
				(int) Rachel.recParent.getY(),
				(int) Rachel.recParent.getWidth(),
				(int) Rachel.recParent.getHeight());
		g.drawRect((int) Rachel.recChild0.getX(),
				(int) Rachel.recChild0.getY(),
				(int) Rachel.recChild0.getWidth(),
				(int) Rachel.recChild0.getHeight());
		g.drawRect((int) Rachel.recChild1.getX(),
				(int) Rachel.recChild1.getY(),
				(int) Rachel.recChild1.getWidth(),
				(int) Rachel.recChild1.getHeight());
		*/
		// draw score
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Score: ", 500, 30);
		g.drawString(Integer.toString(score), 560, 30);	

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

		case KeyEvent.VK_Z:
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

		case KeyEvent.VK_Z:
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

	public static int getScore() {
		return score;
	}

	public static void setScore(int s) {
		score = s;
	}

}