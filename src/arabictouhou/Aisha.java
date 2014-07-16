package arabictouhou;

import java.awt.Graphics;

public class Aisha {
	// initial position of Aisha's sprite
	private int centerX = 240;
	private int centerY = 550;
	final int moveSpeed = 4;

	// the character will not be moving by default
	private int speedX = 0;
	private int speedY = 0;

	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;

	private static Background bg1 = MainClass.getBg1();
	private static Background bg2 = MainClass.getBg2();

	public void update() {
		// remember not to scroll the background with Aisha's movements

		// if speedX is less than 0 and centerX is greater than 40, move Aisha
		// left
		if (centerX >= 40 && speedX < 0) {
			centerX += speedX;
		}

		// if speedX is greater than 0 and centerX is less than 440, move Aisha
		// right
		if (centerX <= 440 && speedX > 0) {
			centerX += speedX;
		}

		// if speedY is greater than 0 and centerY is less than 740, move Aisha
		// down
		if (centerY < 740 && speedY < 0) {
			centerY += speedY;
		}

		// if speedX is less than 0 and centerY is greater than 460, move Aisha
		// up
		if (centerY > 460 && speedY < 0) {
			centerY += speedX;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	public void moveUp() {
		speedY = -moveSpeed;
		System.out.println("up");
	}

	public void moveDown() {
		speedY = moveSpeed;
		System.out.println("down");
	}

	public void moveLeft() {
		speedX = -moveSpeed;
		System.out.println("left");
	}

	public void moveRight() {
		speedX = moveSpeed;
		System.out.println("right");
	}

	public void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}

		if (isMovingUp() == false && isMovingDown() == false) {
			speedY = 0;
		}

		if (isMovingUp() == false && isMovingDown() == true) {
			moveDown();
		}

		if (isMovingUp() == true && isMovingDown() == false) {
			moveUp();
		}
	}

	// setters and getters
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

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

}
