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

	enum GameState {
		Running, Dead
	}

	GameState state = GameState.Running;
	private static final long serialVersionUID = 1L;
	public static Aisha aisha;
	public static Rachel rachel;
	public static JIDF jidf1, jidf2, jidf3, jidf4, jidf5, jidf6, jidf7, jidf8,
			jidf9;
	private Image image, aisha1, aisha2, aisha3, aisha4, aisha5, aishaBullet,
			aishaHealth, aishaSpell;
	private Image rachel1, rachel2, rachel3, jidf;
	private Image background;
	private Graphics second;
	private URL base;
	private static Background bg1, bg2;
	private Animation aisha_animate, rachel_animate;
	// stats
	public static int score;
	private Font font = new Font(null, Font.BOLD, 15);

	@Override
	public void init() {
		setSize(800, 700);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		// I might actually be good on the title now
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
		// JIDF
		jidf = getImage(base, "data/enemy1.png");
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
		aishaHealth = getImage(base, "data/Aisha_health.png");
		aishaSpell = getImage(base, "data/Aisha_spell.png");

	}

	@Override
	public void start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(0, -2160);
		aisha = new Aisha();
		rachel = new Rachel(240, 75);
		jidf1 = new JIDF(240, 300);
		jidf2 = new JIDF(200, 250);
		jidf3 = new JIDF(280, 250);
		jidf4 = new JIDF(160, 200);
		jidf5 = new JIDF(320, 200);
		jidf6 = new JIDF(120, 150);
		jidf7 = new JIDF(360, 150);
		jidf8 = new JIDF(80, 100);
		jidf9 = new JIDF(400, 100);
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
		if (state == GameState.Running) {
			while (true) {
				// update Aisha
				getAisha().update();
				// handle her bullets
				ArrayList<Bullet> aishaBullets = getAisha().getBullets();
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
				//update JIDF
				jidf1.update();
				jidf2.update();
				jidf3.update();
				jidf4.update();
				jidf5.update();
				jidf6.update();
				jidf7.update();
				jidf8.update();
				jidf9.update();
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
				if (getAisha().getCurrentHealth() == 0) {
					state = GameState.Dead;
				}
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
		if (state == GameState.Running) {
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
			ArrayList<Bullet> aishaBullets = getAisha().getBullets();
			for (int i = 0; i < aishaBullets.size(); i++) {
				Bullet b = (Bullet) aishaBullets.get(i);
				g.drawImage(aishaBullet, b.getX(), b.getY(), this);
			}
			// then Aisha
			g.drawImage(aisha_animate.getImage(), getAisha().getCenterX() - 30,
					getAisha().getCenterY() - 60, this);
			// then JIDF
			g.drawImage(jidf, jidf1.getCenterX() - 13, jidf1.getCenterY() - 29, this);
			g.drawImage(jidf, jidf2.getCenterX() - 13, jidf2.getCenterY() - 29, this);
			g.drawImage(jidf, jidf3.getCenterX() - 13, jidf3.getCenterY() - 29, this);
			g.drawImage(jidf, jidf4.getCenterX() - 13, jidf4.getCenterY() - 29, this);
			g.drawImage(jidf, jidf5.getCenterX() - 13, jidf5.getCenterY() - 29, this);
			g.drawImage(jidf, jidf6.getCenterX() - 13, jidf6.getCenterY() - 29, this);
			g.drawImage(jidf, jidf7.getCenterX() - 13, jidf7.getCenterY() - 29, this);
			g.drawImage(jidf, jidf8.getCenterX() - 13, jidf8.getCenterY() - 29, this);
			g.drawImage(jidf, jidf9.getCenterX() - 13, jidf9.getCenterY() - 29, this);
			// then Rachel
			g.drawImage(rachel_animate.getImage(), rachel.getCenterX() - 50,
					rachel.getCenterY() - 68, this);
			// draw score
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Score: ", 500, 30);
			g.drawString(Integer.toString(score), 575, 30);
			// draw health
			g.drawString("Health: ", 500, 60);
			int healthStartX = 575;
			for (int i = 0; i < getAisha().getCurrentHealth(); i++) {
				g.drawImage(aishaHealth, healthStartX, 48, this);
				healthStartX += 25;
			}
			healthStartX = 575;
			// draw Spell
			g.drawString("Spell: ", 500, 90);
			for (int i = 0; i < getAisha().getCurrentSpell(); i++) {
				g.drawImage(aishaSpell, healthStartX, 78, this);
				healthStartX += 25;
			}
		} else if (state == GameState.Dead) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 700);
			g.setColor(Color.WHITE);
			g.drawString("Dead", 360, 350);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			getAisha().moveUp();
			getAisha().setMovingUp(true);
			break;

		case KeyEvent.VK_DOWN:
			getAisha().moveDown();
			getAisha().setMovingDown(true);
			break;

		case KeyEvent.VK_LEFT:
			getAisha().moveLeft();
			getAisha().setMovingLeft(true);
			break;

		case KeyEvent.VK_RIGHT:
			getAisha().moveRight();
			getAisha().setMovingRight(true);
			break;

		case KeyEvent.VK_Z:
			getAisha().fire();
			break;

		case KeyEvent.VK_X:
			if (getAisha().getCurrentSpell() > 0) {
				getAisha().spell();
			}
			getAisha().setCurrentSpell(getAisha().getCurrentSpell() - 1);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			getAisha().stopUp();
			break;

		case KeyEvent.VK_DOWN:
			getAisha().stopDown();
			break;

		case KeyEvent.VK_LEFT:
			getAisha().stopLeft();
			break;

		case KeyEvent.VK_RIGHT:
			getAisha().stopRight();
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

	public Aisha getAisha() {
		return aisha;
	}

}