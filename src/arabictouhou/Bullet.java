package arabictouhou;

public class Bullet {
	private int x, y, speedX, speedY;
	private boolean visible;

	public Bullet(int startX, int startY) {
		x = startX;
		y = startY;
		visible = true;
	}

	public void update() {
		y += speedY;
		if (x > 480 || x < 0) {
			visible = false;
		}
		if (y > 700 || y < 0) {
			visible = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
