package arabictouhou;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Rachel {

	// stats and positioning
	private int maxHealth = 100;
	private int currentHealth, power, speedX, speedY, centerX, centerY;
	// other necessities
	private Background bg = MainClass.getBg1();
	private ArrayList<Bullet> bullets = new ArrayList<>();
	// rectangles for collisions
	public Rectangle recParent = new Rectangle(0, 0, 0, 0);
	public Rectangle recChild0 = new Rectangle(0, 0, 0, 0);
	public Rectangle recChild1 = new Rectangle(0, 0, 0, 0);

	public Rachel(int centerX, int centerY) {
		setCenterX(centerX);
		setCenterY(centerY);
		currentHealth = maxHealth;
	}

	public void update() {
		speedY = bg.getSpeedY();
		recParent.setRect(centerX - 47, centerY - 65, 90, 95);
		recChild0.setRect(centerX - 47, centerY + 30, 30, 30);
		recChild1.setRect(centerX + 13, centerY + 30, 30, 30);
	}

	public void die() {

	}

	public void attack() {

	}

	public int getMaxHealth() {
		return maxHealth;
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

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
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
