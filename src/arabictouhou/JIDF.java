package arabictouhou;

import java.awt.Rectangle;
import java.util.ArrayList;

public class JIDF {

	// stats and positioning
	private int currentHealth = 5;
	private int power, speedX, speedY, centerX, centerY;
	// other necessities
	private Background bg = MainClass.getBg1();
	private ArrayList<Bullet> bullets = new ArrayList<>();
	// rectangles for collisions
	public Rectangle rec = new Rectangle(0, 0, 0, 0);

	public JIDF(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
	}

	public void update() {
		speedY = bg.getSpeedY();
		rec.setRect(centerX - 13, centerY - 29, 26, 58);
	}

	public void fire() {
		Bullet b1 = new Bullet(getCenterX() - 30, getCenterY() - 30);
		b1.setSpeedX(-8);
		b1.setSpeedY(-8);
		bullets.add(b1);
		Bullet b2 = new Bullet(getCenterX() + 30, getCenterY() - 30);
		b2.setSpeedX(8);
		b2.setSpeedY(-8);
		bullets.add(b2);
		Bullet b3 = new Bullet(getCenterX() - 30, getCenterY() + 30);
		b3.setSpeedX(-8);
		b3.setSpeedY(8);
		bullets.add(b3);
		Bullet b4 = new Bullet(getCenterX() + 30, getCenterY() + 30);
		b4.setSpeedX(8);
		b4.setSpeedY(8);
		bullets.add(b4);
		Bullet b5 = new Bullet(getCenterX() - 15, getCenterY());
		b5.setSpeedX(-8);
		b5.setSpeedY(0);
		bullets.add(b5);
		Bullet b6 = new Bullet(getCenterX() + 15, getCenterY());
		b6.setSpeedX(8);
		b6.setSpeedY(0);
		bullets.add(b6);
		Bullet b7 = new Bullet(getCenterX(), getCenterY() + 15);
		b7.setSpeedX(0);
		b7.setSpeedY(8);
		bullets.add(b7);
		Bullet b8 = new Bullet(getCenterX(), getCenterY() - 15);
		b8.setSpeedX(0);
		b8.setSpeedY(-8);
		bullets.add(b8);
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBg() {
		return bg;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBg(Background bg) {
		this.bg = bg;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

}
