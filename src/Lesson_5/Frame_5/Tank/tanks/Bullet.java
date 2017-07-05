package Lesson_5.Frame_5.Tank.tanks;

import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.interfaces.Destroyable;
import Lesson_5.Frame_5.Tank.interfaces.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Bullet implements Drawable, Destroyable {

	private int speed = 5;
	
	private int x;
	private int y;
	private Direction direction;

	private boolean destroyed;

	protected String IMAGE_NAME = "Bullet.png";
	protected Image image;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.destroyed = false;
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void updateY(int y) {
		this.y += y;
	}
	
	@Override
	public void draw(Graphics g) {
		if (!destroyed) {
			if (IMAGE_NAME != null) {
				try {
					image = ImageIO.read(new File(IMAGE_NAME));
				} catch (IOException e) {
					System.err.println("Can't find file: " + IMAGE_NAME);
				}
			}
			g.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image image, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
//		if (!destroyed) {
//			g.setColor(new Color(255, 255, 0));
//			g.fillRect(this.x, this.y, 14, 14);
//		}
		}
	}
	
	public void destroy() {
		destroyed = true;
	}
	
	@Override
	public boolean isDestroyed() {
		return destroyed;
	}

	public int getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return direction;
	}
}
