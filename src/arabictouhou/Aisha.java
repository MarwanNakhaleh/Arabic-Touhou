package arabictouhou;

public class Aisha {
	// initial position of Aisha's sprite
	private int centerX = 240;
	private int centerY = 550;
	private int moveSpeed = 4;

	// the character will not be moving by default
	private int speedX = 0;
	private int speedY = 0;
	
	public boolean movingLeft = false;
	public boolean movingRight = false;
	public boolean movingUp = false;
	public boolean movingDown = false;
	
	private static Background bg1 = MainClass.getBg1();
	private static Background bg2 = MainClass.getBg2();

	public void update() {
		// Moves Character or Scrolls Background accordingly.

		if (speedX < 0) {
			centerX += speedX;
		}
		
		if(centerY < 0){
			centerY += speedY;
		}
		
		//keep the background moving
		bg1.setSpeedY(2);
		bg2.setSpeedY(0);

		centerX += speedX;
		if (centerX <= 440 && speedX > 0) {
			centerX += speedX;
		}

		// updates y position
		centerY += speedY;
		if (centerY + speedY >= 620) {
			centerY = 620;
		}

		// prevents going beyond X coordinate of 0
		if (centerX + speedX <= 40) {
			centerX = 41;
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

	public void stop() {
		if (!isMovingRight() && !isMovingLeft() && !isMovingDown() && !isMovingUp()) {
			speedX = 0;
			speedY = 0;
		}
	}

	public void moveUp() {
		System.out.println("up");
		speedY = -moveSpeed;
	}

	public void moveDown() {
		System.out.println("down");
		speedY = moveSpeed;
	}

	public void moveLeft() {
		System.out.println("left");
		speedX = -moveSpeed;
	}

	public void moveRight() {
		System.out.println("right");
		speedX = moveSpeed;
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
