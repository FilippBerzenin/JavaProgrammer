package Lesson_5.Frame_4.tank.bf;

import Lesson_5.Frame_4.tank.interfaces.BFObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;


public abstract class SimpleBFObject implements BFObject {

	// current position on BF
	private int x;
	private int y;

	protected String IMAGE_NAME;
	protected Image image;
	
	protected Color color;

	protected boolean isDestroyed = false;
	
	public SimpleBFObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void destroy() {
		isDestroyed = true;
	}
	
	@Override
	public void draw(Graphics g) {
		if (IMAGE_NAME != null && !isDestroyed) {
			try {
				image = ImageIO.read(new File(IMAGE_NAME));
			} catch (IOException e) {
				System.err.println("Can't find file: " + IMAGE_NAME);
			}
		}
		if (isDestroyed) {
//			g.setColor(this.color);
//			g.fillRect(this.getX(), this.getY(), 64, 64);
			try {
				image = ImageIO.read(new File("Blank.png"));
			} catch (IOException e) {
				System.err.println("Can't find file: " + "Blank.png");
			}
		}
			g.drawImage(image, this.getX(), this.getY(), new ImageObserver() {
				@Override
				public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
					return false;
				}
			});
		}

	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String getIMAGE_NAME() {
		return IMAGE_NAME;
	}

	public void setIMAGE_NAME(String IMAGE_NAME) {
		this.IMAGE_NAME = IMAGE_NAME;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
