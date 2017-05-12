package Lesson_5.Frame_4.tank.interfaces;

import Lesson_5.Frame_4.tank.enums.Action;
import Lesson_5.Frame_4.tank.enums.Direction;
import Lesson_5.Frame_4.tank.tanks.Bullet;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp();

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();
}
