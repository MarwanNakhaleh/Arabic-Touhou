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
	private Image image, character, background;
	private URL base;
	private Graphics second;
	// we need two backgrounds for smooth looping
	private static Background bg1, bg2;

	// build the applet frame
	@Override
	public void init() {
		//create frame
		setSize(480, 800);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Satan's Cabana Girls: Army of Sluts");
		//document base for images
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// lel ur fucked m9
		}
		//images
		character = getImage(base, "data/Aisha_sprite0.png");
		background = getImage(base, "data/background.png");
	}

	// create a thread that refreshes once every 1/60 seconds
	@Override
	public void start() {
		//two backgrounds for looping
		bg1 = new Background(0, 0);
		bg2 = new Background(0, 2160);
		//create Aisha and start thread
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

	// run the thread once every 1/60 seconds
	@Override
	public void run() {
		while (true) {
			//update Aisha and backgrounds
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
	
	// draw everything on the screen
		@Override
		public void paint(Graphics g) {
			g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
			g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
			//Aisha is 60x120
			g.drawImage(character, aisha.getCenterX() - 30,
					aisha.getCenterY() - 60, this);
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
			// fire
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			aisha.setMovingUp(false);
			aisha.stop();
			break;
		case KeyEvent.VK_DOWN:
			aisha.setMovingDown(false);
			aisha.stop();
			break;
		case KeyEvent.VK_LEFT:
			aisha.setMovingLeft(false);
			aisha.stop();
			break;
		case KeyEvent.VK_RIGHT:
			aisha.setMovingRight(false);
			aisha.stop();
			break;
		case KeyEvent.VK_SPACE:
			// stop firing
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// nothing goes here
	}

	public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}

}
