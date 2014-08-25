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
		x += speedX;
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
		if(rec.intersects(MainClass.jidf1.rec)){
			visible = false;
			if (MainClass.jidf1.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf1.setCurrentHealth(MainClass.jidf1
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf1.getCurrentHealth() == 0){
				MainClass.jidf1.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf2.rec)){
			visible = false;
			if (MainClass.jidf2.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf2.setCurrentHealth(MainClass.jidf2
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf2.getCurrentHealth() == 0){
				MainClass.jidf2.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf3.rec)){
			visible = false;
			if (MainClass.jidf3.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf3.setCurrentHealth(MainClass.jidf3
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf3.getCurrentHealth() == 0){
				MainClass.jidf3.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf4.rec)){
			visible = false;
			if (MainClass.jidf4.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf4.setCurrentHealth(MainClass.jidf4
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf4.getCurrentHealth() == 0){
				MainClass.jidf4.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf5.rec)){
			visible = false;
			if (MainClass.jidf5.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf5.setCurrentHealth(MainClass.jidf5
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf5.getCurrentHealth() == 0){
				MainClass.jidf5.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf6.rec)){
			visible = false;
			if (MainClass.jidf6.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf6.setCurrentHealth(MainClass.jidf6
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf6.getCurrentHealth() == 0){
				MainClass.jidf6.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf7.rec)){
			visible = false;
			if (MainClass.jidf7.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf7.setCurrentHealth(MainClass.jidf7
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf7.getCurrentHealth() == 0){
				MainClass.jidf7.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf8.rec)){
			visible = false;
			if (MainClass.jidf8.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf8.setCurrentHealth(MainClass.jidf8
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf8.getCurrentHealth() == 0){
				MainClass.jidf8.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
			}
		}
		if(rec.intersects(MainClass.jidf9.rec)){
			visible = false;
			if (MainClass.jidf9.getCurrentHealth() > 0) {
				MainClass.setScore(MainClass.getScore() + 1);
				MainClass.jidf9.setCurrentHealth(MainClass.jidf9
						.getCurrentHealth() - 1);
			}
			if(MainClass.jidf9.getCurrentHealth() == 0){
				MainClass.jidf9.setCenterX(-500);
				MainClass.setScore(MainClass.getScore() + 10);
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
