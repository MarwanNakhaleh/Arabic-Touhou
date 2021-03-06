package arabictouhou;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Aisha {

	// collision detection
	public static Rectangle rec = new Rectangle(0, 0, 0, 0);

	// Aisha's stats
	private int currentHealth = 5;
	private int currentSpell = 3;

	// constraints on the movement of Aisha and background
	final int BACKGROUND_SPEED = 1;
	final int MOVESPEED = 5;
	final int BOTTOM = 600;
	final int TOP = 50;

	// aisha's starting position variables
	private int centerX = 240;
	private int centerY = BOTTOM;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;

	// aisha's starting velocity variables
	private int speedX = 0;
	private int speedY = 0;

	// upating the background too
	private Background bg1 = MainClass.getBg1();
	private Background bg2 = MainClass.getBg2();

	private ArrayList<Bullet> bullets = new ArrayList<>();

	public void update() {

		bg1.setSpeedY(BACKGROUND_SPEED);
		bg2.setSpeedY(BACKGROUND_SPEED);

		// if speedX is less than 0, move Aisha backwards but don't scroll
		// the background
		if (speedX < 0) {
			centerX += speedX;
		}

		// if centerX is less than or equal to 200 and speedX is greater than 0,
		// move Aisha forward on the screen but don't scroll the background
		// this shit needs refactoring
		if (centerX <= 450 && speedX > 0) {
			centerX += speedX;
		}

		// stop Aisha at the bottom level
		centerY += speedY;
		if (centerY + speedY >= BOTTOM) {
			centerY = BOTTOM;
		}

		// don't let Aisha move too far up either
		if (centerY + speedY <= TOP) {
			centerY = TOP;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 30) {
			centerX = 31;
		}

		rec.setRect(centerX - 8, centerY - 25, 15, 50);
	}

	public void moveRight() {
		speedX = MOVESPEED;
	}

	public void moveLeft() {
		speedX = -MOVESPEED;
	}

	public void moveDown() {
		speedY = MOVESPEED;
	}

	public void moveUp() {
		speedY = -MOVESPEED;
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	public void stopDown() {
		setMovingDown(false);
		stop();
	}

	public void stopUp() {
		setMovingUp(false);
		stop();
	}

	private void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

		if (isMovingDown() == false && isMovingUp() == false) {
			speedY = 0;
		}

		if (isMovingDown() == false && isMovingUp() == true) {
			moveUp();
		}

		if (isMovingDown() == true && isMovingUp() == false) {
			moveDown();
		}

	}

	public void fire() {
		Bullet b = new Bullet(centerX - 8, centerY - 60);
		b.setSpeedX(0);
		b.setSpeedY(-15);
		bullets.add(b);
	}
	
	public void spell(){
		int perimeterX = MainClass.rachel.getCenterX() - 50;
		int perimeterY = MainClass.rachel.getCenterY() + 125;
		for(int i = 0; i < 10; i++){
			Bullet b = new Bullet(perimeterX, perimeterY);
			bullets.add(b);
			b.setSpeedX(0);
			b.setSpeedY(-8);
			perimeterX += 10;
		}
		perimeterX = MainClass.rachel.getCenterX() - 100;
		perimeterY = MainClass.rachel.getCenterY() + 45;
		for(int i = 0; i < 12; i++){
			Bullet b = new Bullet(perimeterX, perimeterY);
			bullets.add(b);
			b.setSpeedX(8);
			b.setSpeedY(0);
			perimeterY -= 10;
		}
		perimeterX = MainClass.rachel.getCenterX() + 100;
		perimeterY = MainClass.rachel.getCenterY() + 45;
		for(int i = 0; i < 12; i++){
			Bullet b = new Bullet(perimeterX, perimeterY);
			bullets.add(b);
			b.setSpeedX(-8);
			b.setSpeedY(0);
			perimeterY -= 10;
		}
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public int getBACKGROUND_SPEED() {
		return BACKGROUND_SPEED;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getCurrentSpell() {
		return currentSpell;
	}

	public void setCurrentSpell(int currentSpell) {
		this.currentSpell = currentSpell;
	}

}
