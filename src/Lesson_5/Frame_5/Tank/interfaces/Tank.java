package Lesson_5.Frame_5.Tank.interfaces;

import Lesson_5.Frame_5.Tank.enums.Action;
import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.tanks.Bullet;

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

	public void setEnemyCoordinates(int[] enemyCoordinates);

	public int[] getEnemyCoordinates();

	void findEagle();

	void setEnemy(int x, int y);

	void findEnemy(int x, int y);
}
