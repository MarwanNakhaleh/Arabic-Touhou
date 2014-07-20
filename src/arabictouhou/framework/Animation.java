package arabictouhou.framework;

import java.awt.Image;
import java.util.ArrayList;

// commenting liberally?
public class Animation {
	// think of this like a .gif
	private ArrayList<AnimFrame> frames;
	private int currentFrame;
	private long animTime;
	private long totalDuration;

	// constructor for an empty animation
	public Animation() {
		frames = new ArrayList<AnimFrame>();
		totalDuration = 0;

		synchronized (this) {
			animTime = 0;
			currentFrame = 0;
		}
	}

	// indefinitely lengthen your animation
	public synchronized void addFrame(Image image, long duration) {
		totalDuration += duration;
		frames.add(new AnimFrame(image, totalDuration));
	}

	// switch to the next AnimFrame and loop the animation
	public synchronized void update(long elapsedTime) {
		if (frames.size() > 1) {
			animTime += elapsedTime;
			if (animTime >= totalDuration) {
				animTime = animTime % totalDuration;
				currentFrame = 0;
			}
			while (animTime >= getFrame(currentFrame).endTime) {
				currentFrame++;
			}
		}
	}

	// return our image
	public synchronized Image getImage() {
		if (frames.size() == 0) {
			return null;
		} else {
			return getFrame(currentFrame).image;
		}
	}

	// show me my frame!
	private AnimFrame getFrame(int i) {
		return (AnimFrame) frames.get(i);
	}

	// each AnimFrame needs an image and a duration
	private class AnimFrame {
		Image image;
		long endTime;

		public AnimFrame(Image image, long endTime) {
			this.image = image;
			this.endTime = endTime;
		}
	}
}
