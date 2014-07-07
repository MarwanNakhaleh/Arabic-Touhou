package arabictouhou;

public class Aisha {
	// initial position of Aisha's sprite
	private int centerX = 240;
	private int centerY = 650;

	// the character will have to move upward on the screen by default
	private int speedX = 0;
	private int speedY = 0;

	public void update() {

		// scroll the background

		// allows the character to move around
		if (speedX > 0) {
			centerX += speedX;
		}
		if (speedY > 0) {
			centerY += speedY;
		}

		// let's not move Aisha too far up or down on the screen
		if (centerY + speedY >= 702) {
			centerY = 702;
		} else {
			centerY += speedY;
		}

		if (centerY + speedY <= 400) {
			centerY += 400;
		} else {
			centerY += speedY;
		}

		// let's not let her go too far left or right either
		if (centerX + speedX <= 60) {
			centerX = 61;
		} else {
			centerX += speedX;
		}

		if (centerX + speedX >= 420) {
			centerX = 419;
		} else {
			centerX += speedX;
		}
	}

	public void moveUp() {
		speedY = -4;
	}

	public void moveDown() {
		speedY = 4;
	}

	public void moveLeft() {
		speedX = -4;
	}

	public void moveRight() {
		speedX = 4;
	}

	public void stop() {
		speedX = 0;
		speedY = 0;
	}

}
