package Lesson_5.Frame_4.tank.bf;

import java.awt.*;

public class Rock extends SimpleBFObject {
	
	public Rock(int x, int y) {
		super(x, y);
//		color = new Color(0, 0, 55);
		IMAGE_NAME = "Rock.png";
	}

	@Override
	public void destroy() {
		isDestroyed = false;
	}

}
