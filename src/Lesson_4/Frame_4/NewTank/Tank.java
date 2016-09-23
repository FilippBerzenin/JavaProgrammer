package Lesson_4.Frame_4.NewTank;

public interface Tank extends Drawable, Destroyable {
	
	public Action setUp() throws Exception;

	public void move();

	public Bullet fire();

	public int getX();

	public int getY();
	
	public Direction getDirection();
	
	public void updateX(int x);

	public void updateY(int y);
	
	public int getSpeed();
	
	public int getMovePath();

	void turn(Direction down);

	void moveToEagle();
}
