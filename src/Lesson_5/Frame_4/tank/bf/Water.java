package Lesson_5.Frame_4.tank.bf;

import java.awt.*;

public class Water extends SimpleBFObject {
	
	public Water(int x, int y) {
		super(x, y);
//		color = new Color(0, 0, 255);
		IMAGE_NAME = "Water.png";
	}

	@Override
	public void destroy() {
		isDestroyed = false;
	}
}
