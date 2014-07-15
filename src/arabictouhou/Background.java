package arabictouhou;

public class Background {
	private int bgX, bgY, speedY;

	// the background will always be scrolling down, giving the illusion that
	// Aisha is moving up
	public Background(int x, int y) {
		bgX = x;
		bgY = y;
		speedY = -2;
	}

	// loop a 480 x 2160 background... until I make the other background
	public void update() {
		bgY += speedY;
		if (bgY <= -2160) {
			bgY += 4320;
		}
	}

	// getters and setters are always useful
	public int getBgX() {
		return bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
