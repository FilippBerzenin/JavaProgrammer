package Lesson_5.Frame_4.tank.tanks;

import Lesson_5.Frame_4.tank.enums.Direction;
import Lesson_5.Frame_4.tank.BattleField;
import Lesson_5.Frame_4.tank.interfaces.Tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public abstract class AbstractTank implements Tank {
	
	private int speed = 2; // first value - 10
	protected int movePath = 1;

	// 1 - up, 2 - down, 3 - left, 4 - right
	protected Direction direction;

	// current position on BF
	private int x;
	private int y;

	protected boolean destroyed;
	
	protected BattleField bf;
	
	protected Color tankColor;
	protected Color towerColor;

	protected String IMAGE_NAME;
	protected Image image;


	public AbstractTank(BattleField bf) {
		this(bf, 128, 512, Direction.LEFT);
	}
	
	public AbstractTank(BattleField bf, int x, int y, Direction direction) {
		this.bf = bf;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
	}

	public void turn(Direction direction) {
		this.direction = direction;
	}

	public void move() {
	}
	
	public Bullet fire() {
		int bulletX = -100;
		int bulletY = -100;
		if (direction == Direction.UP) {
			bulletX = x + 25;
			bulletY = y;
		} else if (direction == Direction.DOWN) {
			bulletX = x + 25;
			bulletY = y + 64;
		} else if (direction == Direction.LEFT) {
			bulletX = x;
			bulletY = y + 25;
		} else if (direction == Direction.RIGHT) {
			bulletX = x + 64;
			bulletY = y + 25;
		}
		return new Bullet(bulletX, bulletY, direction);
	}

	int turnX;
	int turnY;


	public void draw(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		if (!destroyed) {
			if (IMAGE_NAME != null) {
				try {
					image = ImageIO.read(new File(IMAGE_NAME));
				} catch (IOException e) {
					System.err.println("Can't find file: " + IMAGE_NAME);
				}
			}
//			Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
//			g2d.translate(this.getX()/2, this.getY()/2); // Translate the center of our coordinates.
//			g2d.rotate(1);  // Rotate the image by 1 radian.
//			g2d.drawImage(image, this.getX(), this.getY(), 20, 20, new ImageObserver() {
//				@Override
//				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
//					return false;
//				}
//			});
//
//			g.setColor(tankColor);
//			g.fillRect(this.getX(), this.getY(), 64, 64);
//			g.setColor(towerColor);
//			if (this.getDirection() == Direction.UP) {
//				turnX=0;
//				turnY=0;
//				g.fillRect(this.getX() + 20, this.getY(), 24, 34);
//			} else if (this.getDirection() == Direction.DOWN) {
//				turnX=180;
//				turnY=180;
//				g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
//			} else if (this.getDirection() == Direction.LEFT) {
//				turnX=90;
//				turnY=90;
//				g.fillRect(this.getX(), this.getY() + 20, 34, 24);
//			} else {
//				turnX=270;
//				turnY=270;
//				g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
//			}
		}
		if (this.getDirection() == Direction.UP) {
			g2d.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
		}
		if (this.getDirection() == Direction.DOWN) {
			g2d.translate(this.getX(), this.getY());
			g2d.rotate(Math.PI);
			g2d.translate(-this.getX()-64, -this.getY()-64);
			g2d.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
		}
		if (this.getDirection() == Direction.LEFT) {
			g2d.translate(this.getX(), this.getY());
			g2d.rotate(Math.PI*3/2);
			g2d.translate(-this.getX()-64, -this.getY());
			g2d.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
		}
		if (this.getDirection() == Direction.RIGHT) {
			g2d.translate(this.getX(), this.getY());
			g2d.rotate(Math.PI/2);
			g2d.translate(-this.getX(), -this.getY()-64);
			g2d.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
		}
//		g.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
//			@Override
//			public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
//				return false;
//			}
//		});
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public void destroy() {
		destroyed = true;
	}
	
	public void moveToQuadrant(int v, int h) throws Exception {
	}
	
	public void moveRandom() throws Exception { 
	}

	public void clean() throws Exception {
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getSpeed() {
		return speed;
	}

	public String tankLocation (int x, int y) {
		return y / 64 + "_" + x / 64;
	}
	
	@Override
	public int getMovePath() {
		return movePath;
	}
}