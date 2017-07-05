package Lesson_5.Frame_5.Tank.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {
	
	public Water(int x, int y) {
		super(x, y);
		color = new Color(0, 0, 255);
		IMAGE_NAME = "Blank.png";
		try {
			image = ImageIO.read(new File("Water.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Composite org = g2d.getComposite();
		Composite trasns = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
		g2d.setComposite(trasns);
		g.drawImage(image, getX(), getY(), new ImageObserver() {
			@Override
			public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
				return false;
			}
		});
		g2d.setComposite(org);
	}
}
