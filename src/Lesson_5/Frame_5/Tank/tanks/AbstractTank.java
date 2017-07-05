package Lesson_5.Frame_5.Tank.tanks;

import Lesson_5.Frame_5.Tank.BattleField;
import Lesson_5.Frame_5.Tank.bf.Blank;
import Lesson_5.Frame_5.Tank.bf.Eagle;
import Lesson_5.Frame_5.Tank.bf.Rock;
import Lesson_5.Frame_5.Tank.bf.SimpleBFObject;
import Lesson_5.Frame_5.Tank.enums.Action;
import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.interfaces.Tank;
import tanks.bf.Water;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractTank implements Tank {
	
	private int speed = 10; // first value - 10
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
	protected BufferedImage bufferedImage;
	protected int[] enemyCoordinates;
	protected int[] enemy;
	protected String[][] wayFrom;
	protected int[] eagleLocation;
	protected int wayX;
	protected int wayY;
	protected int eagleX;
	protected int eagleY;
	protected int enemyX;
	protected int enemyY;
	protected boolean eagleFind = false;
	protected boolean defenderFinf = false;


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


	public void draw(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;
		if (!destroyed) {
			if (IMAGE_NAME != null) {
				try {
					image = ImageIO.read(new File(IMAGE_NAME));
					bufferedImage = ImageIO.read(new File(IMAGE_NAME));
				} catch (IOException e) {
					System.err.println("Can't find file: " + IMAGE_NAME);
				}
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
				double rotationRequired = Math.toRadians(180);
				double locationX = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				double locationY = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(bufferedImage, null), x, y, null);
			}
			if (this.getDirection() == Direction.LEFT) {
				double rotationRequired = Math.toRadians(270);
				double locationX = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				double locationY = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(bufferedImage, null), x, y, null);
			}
			if (this.getDirection() == Direction.RIGHT) {
				double rotationRequired = Math.toRadians(90);
				double locationX = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				double locationY = image.getHeight(new ImageObserver() {
					@Override
					public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
						return false;
					}
				}) / 2;
				AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
				AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
				g2d.drawImage(op.filter(bufferedImage, null), x, y, null);
			}
		}
	}

	public void findEagle() {
		eagleLocation = locationOfEagle();
		eagleX = eagleLocation[1];
		eagleY = eagleLocation[0];
		wayX = eagleX;
		wayY = eagleY;
		wayFrom = bf.getBattleFieldTemplate();
		fillArrays(this.getY() / 64, this.getX() / 64);
	}

	public void findEnemy(int enemyX, int enemyY) {
		this.enemyX = enemyX;
		this.enemyY = enemyY;
		eagleLocation = locationOfEnemy();
		eagleX = eagleLocation[1];
		eagleY = eagleLocation[0];
		wayX = eagleX;
		wayY = eagleY;
		wayFrom = bf.getBattleFieldTemplate();
		fillArrays(this.getY() / 64, this.getX() / 64);
	}

	private int[] locationOfEnemy () {
		enemyCoordinates = new int[2];
		enemyCoordinates[1] = enemyX/64;
		enemyCoordinates[0] = enemyY/64;
		return enemyCoordinates;
	}

	protected Action actionTank() {
		if (targetCoordinates(eagleX, eagleY) == true || enemyOnTarget() == true) {
			return Action.FIRE;		}
		for (int i = way.size()-1; i>0; i--) {
			if (way.get(i).wayD[4].equals(Direction.DOWN)) {
				turn(Direction.UP);
			}
			if (way.get(i).wayD[4].equals(Direction.UP)) {
				turn(Direction.DOWN);
			}
			if (way.get(i).wayD[4].equals(Direction.LEFT)) {
				turn(Direction.RIGHT);
			}
			if (way.get(i).wayD[4].equals(Direction.RIGHT)) {
				turn(Direction.LEFT);
			}
			way.remove(i);
			return Action.MOVE;
		}
		return Action.NONE;
	}

	private boolean enemyOnTarget () {
		if (enemyX/64 == this.getX()/64) {
			if (enemyY / 64 > this.getY() / 64) {
				for (int i = enemyY / 64 - 1; i > this.getY() / 64; i--) {
					if ((bf.scanQuadrant(i, this.getX() / 64) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.DOWN);
				return true;
			} else if (enemyY / 64 < this.getY() / 64) {
				for (int i = enemyY / 64; i < this.getY() / 64; i++) {
					if ((bf.scanQuadrant(i, this.getX() / 64) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.UP);
				return true;
			}
		}
		if (enemyY/64 == this.getY()/64) {
			if (enemyX/64 > this.getX()/64) {
				for (int i = this.getX()/64; i < enemyX/64; i++) {
					if ((bf.scanQuadrant(this.getY()/64, i) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.RIGHT);
				return true;
			}
			else if (enemyX/64 < this.getX()/64) {
				for (int i = enemyX/64 + 1; i < this.getX() / 64; i++) {
					if ((bf.scanQuadrant(this.getY() / 64, i) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.LEFT);
				return true;
			}
		}
		return false;
	}

	private boolean targetCoordinates (int targetX, int targetY) {
		if (targetY == this.getY()/64) {
			if (targetX > this.getX()/64) {
				for (int i = this.getX()/64; i < targetX; i++) {
					if ((bf.scanQuadrant(this.getY()/64, i) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.RIGHT);
				return true;
			}
			else if (targetX < this.getX()/64) {
				for (int i = targetX + 1; i < this.getX() / 64; i++) {
					if ((bf.scanQuadrant(this.getY() / 64, i) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.LEFT);
				return true;
			}
		}
		if (targetX == this.getX()/64) {
			if (targetY > this.getY()/64) {
				for (int i = targetY - 1; i > this.getY() / 64; i--) {
					if ((bf.scanQuadrant(i, this.getX() / 64) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.DOWN);
				return true;
			}
			else if (targetY < this.getY()/64) {
				for (int i = targetY; i < this.getY() / 64; i++) {
					if ((bf.scanQuadrant(i, this.getX() / 64) instanceof Rock)) {
						return false;
					}
				}
				turn(Direction.UP);
				return true;
			}
		}
		return false;
	}

	private int[] locationOfEagle () {
		eagleLocation = new int[2];
		int v = 0;
		int h = 0;
		for (int y = 0; y < bf.getBfHeight() / 64; y++) {
			for (int x = 0; x < bf.getBfWidth() / 64; x++) {
				if (bf.scanQuadrant(y, x) instanceof Eagle && (v>=0 && v<9 && h>=0 && h<9)) {
					v = y;
					eagleLocation[0] = y;
					h = x;
					eagleLocation[1] = x;
					return eagleLocation;
				}
			}
		}
		return null;
	}

	class position {
		Direction[] wayD;
		int y;
		int x;

		position (Direction[] wayD, int y, int x) {
			this.wayD = wayD;
			this.y = y;
			this.x = x;
		}

		public Direction[] getWayD() {
			return wayD;
		}
	}

	ArrayList<position> way = new ArrayList<>();

	private void fillArrays (int tankY, int tankX) {
		int[] targetLocation = eagleLocation;
		int eagleX = targetLocation[1];
		int eagleY = targetLocation[0];
		Direction[] step;
		boolean stop = true;

		while (stop) {
			if (way.size() == 0) {
				step = fillDirection(eagleX, eagleY);
				way.add(0, new position(step,wayY, wayX));
			}
			else {
				if (way.get(way.size()-1).wayD[0] != null && way.get(way.size()-1).wayD[4].equals(Direction.RIGHT)) {
					if (wayX == tankX && wayY == tankY) {
						stop = false;
						break;
					} else
						step = fillDirection(wayX, wayY);
					way.add(new position(step, wayY, wayX));
				}
				else if (way.get(way.size()-1).wayD[1] != null && way.get(way.size()-1).wayD[4].equals(Direction.LEFT)) {
					if (wayX == tankX && wayY == tankY) {
						stop = false;
						break;
					} else
						step = fillDirection(wayX, wayY);
					way.add(new position(step, wayY, wayX));
				}
				else if (way.get(way.size()-1).wayD[2] != null && way.get(way.size()-1).wayD[4].equals(Direction.UP)) {
//				wayY--;
					if (wayX == tankX && wayY == tankY) {
						stop = false;
						break;
					} else
						step = fillDirection(wayX, wayY);
					way.add(new position(step, wayY, wayX));
				}
				else if (way.get(way.size()-1).wayD[3] != null && way.get(way.size()-1).wayD[4].equals(Direction.DOWN)) {
					if (wayX == tankX && wayY == tankY) {
						stop = false;
						break;
					} else
						step = fillDirection(wayX, wayY);
					way.add(new position(step, wayY, wayX));
				}
			}
			if (way.get(way.size()-1).getWayD()[4] == null) {
				int removeLastElement = way.size()-1;
				for (int i = way.size()-1; i>=0; i--) {
					int size = 5;
					for (Direction d: way.get(i).getWayD()) {
						if (d == null){
							size--;
						}
					}
					if (size <= 2) {
						wayFrom[way.get(i).y][way.get(i).x] = "N";
						way.remove(i);
						removeLastElement--;
					}
					else break;
				}
				if (wayFrom[way.get(removeLastElement).y][way.get(removeLastElement).x] != "E") {
					wayFrom[way.get(removeLastElement).y][way.get(removeLastElement).x] = " ";
				}
				way.remove(way.get(removeLastElement));
				if (way.size()>0) {
					wayY = way.get(way.size()-1).y;
					wayX = way.get(way.size()-1).x;
				}
				else {
					wayY = eagleY;
					wayX = eagleX;
				}
			}
			if (way.size()>0) {
				if (way.get(way.size() - 1).getWayD()[4] == Direction.RIGHT) {
					wayX++;
				} else if (way.get(way.size() - 1).getWayD()[4] == Direction.LEFT) {
					wayX--;
				} else if (way.get(way.size() - 1).getWayD()[4] == Direction.UP) {
					wayY--;
				} else if (way.get(way.size() - 1).getWayD()[4] == Direction.DOWN) {
					wayY++;
				}
			}
//			for (int i = 0; i<wayFrom.length;i++) {
//				System.out.println(Arrays.toString(wayFrom[i]));
//			}
//			System.out.println("---------------------");
//			}
		}
	}

	private Direction[] fillDirection (int x, int y) {
		Direction[] dir = new Direction[5];
		if (x>=0 && x <9 && y>=0 && y<9) {
			if (x < 8 && (bf.scanQuadrant(y, x + 1) instanceof Blank || bf.scanQuadrant(y, x + 1) instanceof Water)
					&& wayFrom[y][x+1] != "N" && !wayFrom[y][x + 1].equals("G")) {
				if (!impasse(y, x, y, x + 1)) {
					wayFrom[y][x] = "N";
				}
				else {
					dir[0] = Direction.RIGHT;
					if (wayFrom[y][x + 1] != null) {
						wayFrom[y][x + 1] = "R";
					}
				}
			}
			if (x > 0 && (bf.scanQuadrant(y, x - 1) instanceof Blank || bf.scanQuadrant(y, x - 1) instanceof Water)
					&& wayFrom[y][x-1] != "N" && !wayFrom[y][x - 1].equals("G")) {
				if (!impasse(y, x, y, x - 1)) {
					wayFrom[y][x] = "N";
				}
				else {
					dir[1] = Direction.LEFT;
					if (wayFrom[y][x - 1] != null) {
						wayFrom[y][x - 1] = "L";
					}
				}
			}
			if (y > 0 && (bf.scanQuadrant(y-1, x) instanceof Blank || bf.scanQuadrant(y-1, x) instanceof Water)
					&& wayFrom[y-1][x] != "N" && !wayFrom[y - 1][x].equals("G")) {
				if (!impasse(y, x, y-1, x)) {
					wayFrom[y][x] = "N";
				}
				else {
					dir[2] = Direction.UP;
					if (wayFrom[y - 1][x] != null) {
						wayFrom[y - 1][x] = "U";
					}
				}
			}
			if (y < 8 && (bf.scanQuadrant(y+1, x) instanceof Blank || bf.scanQuadrant(y+1, x) instanceof Water)
					&& wayFrom[y+1][x] != "N" && !wayFrom[y + 1][x].equals("G")) {
				if (!impasse(y, x, y+1, x)) {
					wayFrom[y][x] = "N";
				}
				else {
					dir[3] = Direction.DOWN;
					if (wayFrom[y + 1][x] != null) {
						wayFrom[y + 1][x] = "D";
					}
				}
			}
			mainDirection(dir, y, x);
		}
		return dir;
	}

	private boolean impasse (int y, int x, int yNew, int xNew ) {
		if ((y+1<9 && y+1 == this.getY()/64 && x == this.getX()/64) || (y-1>=0 && y-1 == this.getY()/64 && x == this.getX()/64) ||
				(x+1<9 && x+1 == this.getY()/64 && x+1 == this.getX()/64) || (x+1<9 && x-1 == this.getY()/64 && x-1 == this.getX()/64)) {
			return true;
		}
		if (y < yNew && x == xNew) {
			if (((x+1)<9 && (bf.scanQuadrant(yNew, x+1) instanceof Blank || bf.scanQuadrant(yNew, x+1) instanceof Water)) ||
					((x-1)>=0 && (bf.scanQuadrant(yNew, x-1) instanceof Blank || bf.scanQuadrant(yNew, x-1) instanceof Water)) ||
					((yNew+1)<9 && (bf.scanQuadrant(yNew+1, x) instanceof Blank || bf.scanQuadrant(yNew+1, x) instanceof Water)) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		else if (y > yNew && x == xNew) {
			if (((x+1)<9 && (bf.scanQuadrant(yNew, x+1) instanceof Blank || bf.scanQuadrant(yNew, x+1) instanceof Water)) ||
					((x-1)>=0 && (bf.scanQuadrant(yNew, x-1) instanceof Blank || bf.scanQuadrant(yNew, x-1) instanceof Water)) ||
					((yNew-1)>=0 && (bf.scanQuadrant(yNew-1, x) instanceof Blank || bf.scanQuadrant(yNew-1, x) instanceof Water)) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		else if (y == yNew && x > xNew) {
			if (((y+1)<9 && (bf.scanQuadrant(y+1, xNew) instanceof Blank || bf.scanQuadrant(y+1, xNew) instanceof Water)) ||
					((y-1)>=0 && (bf.scanQuadrant(y-1, xNew) instanceof Blank || bf.scanQuadrant(y-1, xNew) instanceof Water)) ||
					((xNew-1)>=0 && (bf.scanQuadrant(y, xNew-1) instanceof Blank || bf.scanQuadrant(y, xNew-1) instanceof Water)) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		else if (y == yNew && x < xNew) {
			if (((y+1)<9 && (bf.scanQuadrant(y+1, xNew) instanceof Blank || bf.scanQuadrant(y+1, xNew) instanceof Water)) ||
					((y-1)>=0 && (bf.scanQuadrant(y-1, xNew) instanceof Blank || bf.scanQuadrant(y-1, xNew) instanceof Water)) ||
					((xNew+1)<9 && (bf.scanQuadrant(y, xNew+1) instanceof Blank || bf.scanQuadrant(y, xNew+1) instanceof Water)) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		return false;
	}

	private Direction[] mainDirection (Direction[] dir, int y, int x) {
		int length = 5;
		for (Direction d: dir) {
			if (d == null) {
				length--;
			}
		}
		if (length == 1) {
			if (dir[0] == Direction.RIGHT) {
				dir[4] = Direction.RIGHT;
				wayFrom[y][x + 1] = "G";
			}
			else if (dir[1] == Direction.LEFT) {
				dir[4] = Direction.LEFT;
				wayFrom[y][x - 1] = "G";
			}
			else if (dir[2] == Direction.UP) {
				dir[4] = Direction.UP;
				wayFrom[y - 1][x] = "G";
			}
			else if (dir[3] == Direction.DOWN) {
				dir[4] = Direction.DOWN;
				wayFrom[y + 1][x] = "G";
			}
		}
		else if (length > 1) {
			if (dir[0] == Direction.RIGHT && dir[4] == null) {
				if (distanceForTank(y, x, y, x+1) == true) {
					dir[4] = Direction.RIGHT;
					wayFrom[y][x + 1] = "G";
				}
			}
			if (dir[1] == Direction.LEFT && dir[4] == null) {
				if (distanceForTank(y, x, y, x-1) == true) {
					dir[4] = Direction.LEFT;
					wayFrom[y][x - 1] = "G";
				}
			}
			if (dir[2] == Direction.UP && dir[4] == null) {
				if (distanceForTank(y, x, y-1, x) == true) {
					dir[4] = Direction.UP;
					wayFrom[y-1][x] = "G";
				}
			}
			if (dir[3] == Direction.DOWN && dir[4] == null) {
				if (distanceForTank(y, x, y+1, x) == true) {
					dir[4] = Direction.DOWN;
					wayFrom[y+1][x] = "G";
				}
			}
		}
		return  dir;
	}

	private boolean distanceForTank (int baseCoordinateY, int baseCoordinateX, int newCoordinateY, int newCoordinateX) {
		int tankX = this.getX()/64;
		int tankY  = this.getY()/64;
		if (tankY<baseCoordinateY && tankX<=baseCoordinateX) {
			int baseBisector = ((tankY - baseCoordinateY) * (tankY - baseCoordinateY)) + ((tankX - baseCoordinateX) * (tankX - baseCoordinateX));
			int newBisector = ((tankY - newCoordinateY) * (tankY - newCoordinateY)) + ((tankX - newCoordinateX) * (tankX - newCoordinateX));
			if (baseBisector > newBisector) {
				return true;
			}
		}
		else if (tankY<baseCoordinateY && tankX>=baseCoordinateX) {
			int baseBisector = ((tankY - baseCoordinateY) * (tankY - baseCoordinateY)) + ((tankX - baseCoordinateX) * (tankX - baseCoordinateX));
			int newBisector = ((tankY - newCoordinateY) * (tankY - newCoordinateY)) + ((tankX - newCoordinateX) * (tankX - newCoordinateX));
			if (baseBisector > newBisector) {
				return true;
			}
		}
		else if (tankY>=baseCoordinateY && tankX<baseCoordinateX) {
			int baseBisector = ((tankY - baseCoordinateY) * (tankY - baseCoordinateY)) + ((tankX - baseCoordinateX) * (tankX - baseCoordinateX));
			int newBisector = ((tankY - newCoordinateY) * (tankY - newCoordinateY)) + ((tankX - newCoordinateX) * (tankX - newCoordinateX));
			if (baseBisector > newBisector) {
				return true;
			}
		}
		else if (tankY>=baseCoordinateY && tankX>baseCoordinateX) {
			int baseBisector = ((tankY - baseCoordinateY) * (tankY - baseCoordinateY)) + ((tankX - baseCoordinateX) * (tankX - baseCoordinateX));
			int newBisector = ((tankY - newCoordinateY) * (tankY - newCoordinateY)) + ((tankX - newCoordinateX) * (tankX - newCoordinateX));
			if (baseBisector > newBisector) {
				return true;
			}
		}
		return false;
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

	public int[] getEnemyCoordinates() {
		return enemyCoordinates;
	}

	public void setEnemyCoordinates(int[] enemyCoordinates) {
		this.enemyCoordinates = enemyCoordinates;
	}

	public void setEnemy(int enemyX, int enemyY) {
		this.enemyX = enemyX;
		this.enemyY = enemyY;
	}

	@Override
	public int getMovePath() {
		return movePath;
	}
}