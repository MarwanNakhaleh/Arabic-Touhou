package arabictouhou;

import java.awt.Rectangle;

public class Bullet {
	private int x, y, speedX, speedY;
	private boolean visible;
	public static Rectangle rec;

	public Bullet(int startX, int startY) {
		x = startX;
		y = startY;
		visible = true;
		rec = new Rectangle(0, 0, 0, 0);
	}

	public void update() {
		y += speedY;
		rec.setBounds(x, y, 10, 5);
		if (y > 700) {
			visible = false;
			rec = null;
		}
		if (y < 801) {
			checkCollision();
		}
	}

	public void checkCollision() {
		if (rec.intersects(MainClass.rachel.recParent)
				|| rec.intersects(MainClass.rachel.recChild0)
				|| rec.intersects(MainClass.rachel.recChild1)) {
			visible = false;
			if (MainClass.rachel.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.rachel.setCurrentHealth(MainClass.rachel
						.getCurrentHealth() - 1);
			}
			if(MainClass.rachel.getCurrentHealth() == 0){
				MainClass.rachel.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 100);
			}
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
