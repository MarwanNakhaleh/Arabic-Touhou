package arabictouhou;

import java.util.ArrayList;

public class Rachel {

	private int maxHealth, currentHealth, power, speedX, speedY, centerX, centerY;
	private Background bg = MainClass.getBg1();
	private ArrayList<Bullet> bullets = new ArrayList<>();
	
	public Rachel(int centerX, int centerY){
		setCenterX(centerX);
		setCenterY(centerY);
	}
	
	public void update(){
		speedY = bg.getSpeedY();
	}
	
	public void die(){
		
	}
	
	public void attack(){
		
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
	
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}

}
