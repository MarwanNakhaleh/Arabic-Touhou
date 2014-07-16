package arabictouhou;

public class Background {
	
	private int bgX, bgY, speedY;
	private int MAX_HEIGHT = 2160;
	private int LOOP_FACTOR = -4320;
	
	public Background(int x, int y){
		bgX = x;
		bgY = y;
		speedY = 1;
	}
	
	public void update() {
		bgY += speedY;

		if (bgY >= MAX_HEIGHT){
			bgY += LOOP_FACTOR;
		}
	}

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
