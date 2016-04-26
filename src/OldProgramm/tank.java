package finalWorks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * @version 3.0
 */
public class tank extends JPanel {

	final boolean COLORDED_MODE = false;

	static int BF_WIDTH_SQUARE = 9;
	static int BF_HEIGHT_SQUARE = 9;

	static int SQUARE_SIZE_X = 64;
	static int SQUARE_SIZE_Y = SQUARE_SIZE_X;
	
	final int ratio = 64/SQUARE_SIZE_X;

	final int BF_WIDTH = SQUARE_SIZE_X * BF_WIDTH_SQUARE;
	final int BF_HEIGHT = SQUARE_SIZE_Y * BF_HEIGHT_SQUARE;

	final int BORDER_HORIZONT_LEFT = 0;
	final int BORDER_VERTIKAL_LEFT = 0;

	// 1 - top, 2 - bottom, 3 - left, 4 - right
	final int TOP = 8;
	final int BOTTOM = 5;
	final int LEFT = 4;
	final int RIGHT = 6;

	final int BULLET_IPHEAVAL = 25/ratio;
	final int BULLET_SIZE = 14/ratio;

	final int STEP = 1;
	final int BULLET_BORDER = 26/ratio;

	static int AMOUNT_RANDOM_B_OF_PERCENT = 50;
	final int RISK_FACTOR = 10;

	int tankDirection = 1;

	int tankX;
	int tankY;

	int bulletX = -100;
	int bulletY = -100;

	int speed = 2; // faster then 5
	int bulletSpeed = 1;
	
	String[][] battleField = new String[BF_HEIGHT_SQUARE][BF_WIDTH_SQUARE+1];
	// {
	// { "B", " ", "B", " ", "B", " ", "B", " ", "B" },
	// { " ", "B", " ", " ", "B", " ", " ", "B", " " },
	// { " ", " ", " ", "B", "B", "B", " ", " ", " " },
	// { "B", " ", "B", "B", "B", "B", "B", " ", "B" },
	// { " ", " ", " ", "B", "B", "B", " ", " ", " " },
	// { " ", "B", " ", "B", "B", "B", " ", "B", " " },
	// { " ", "B", " ", " ", " ", " ", " ", "B", " " },
	// { " ", "B", " ", "B", "B", "B", " ", "B", " " },
	// { " ", "B", " ", "B", "B", "B", " ", "B", " " }
	// };

	/**
	 * Write your code here.
	 */

	void runTheGame() throws Exception {
		battleField(battleField);
		startPosition();
//		entryDataMove();	
		// moveToQuadrant(1, 5);
		clean();
	}

	void entryDataMove() throws Exception {
		System.out.println("Move to:");		
		for (int i = 0; i < 100; i++) {
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			move(a);
			System.out.println("Ok");
		}
//		sc.close();
	}
	

//	static void entryDataWidth () {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Entry battleField width:");
//		BF_WIDTH_SQUARE = sc.nextInt();
//		sc.close();
//		System.out.println("Ok");
//	}
//	
//	static void entryDataHeight () {
//		Scanner sr = new Scanner(System.in);
//		System.out.println("Entry battleField height:");
//		BF_HEIGHT_SQUARE = sr.nextInt();
//		sr.close();
//		System.out.println("Ok");
//	}
//	
//	static void entryDataSquareSize () {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Entry battleField square size:");
//		SQUARE_SIZE_X = sc.nextInt();
//		sc.close();
//		System.out.println("Ok");
//	}
//	static void entryDataFullBricks () {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Entry battleField full bricks:");
//		AMOUNT_RANDOM_B_OF_PERCENT = sc.nextInt();
//		sc.close();
//		System.out.println("Ok");
//	}
	
	void startPosition() {
		for (int i = 0; i < (BF_HEIGHT_SQUARE * BF_WIDTH_SQUARE) * RISK_FACTOR; i++) {
			tankX = random(BF_WIDTH_SQUARE) * SQUARE_SIZE_X;
			tankY = random(BF_HEIGHT_SQUARE) * SQUARE_SIZE_Y;
			String position = getQuadrant(tankX, tankY);
			int indexVertikal = indexVertikal(position);
			int indexHorizontal = indexHorizontal(position);
			if (equalsB(indexVertikal, indexHorizontal) == false) {
				break;
			}
		}
	}

	void battleField(String[][] battleField) {
		for (int i = 0; i < battleField.length; i++) {
			for (int k = 0; k < battleField[i].length; k++) {
				battleField[i][k] = " ";
			}
		}
		for (int i = 0; i < (BF_HEIGHT_SQUARE * BF_WIDTH_SQUARE) * RISK_FACTOR; i++) {
			int v = random(BF_HEIGHT_SQUARE);
			int h = random(BF_WIDTH_SQUARE);
			battleField[v][h] = "B";
			if (i > random_B()) {
				if (stopLoop() == true) {
					break;
				}
			}
		}
	}

	boolean stopLoop() {
		int x = 0;
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField[j].length; k++) {
				if (battleField[j][k].equals("B")) {
					x += 1;
				}
			}
		}
		if (x == random_B()) {
			return true;
		} else
			return false;
	}

	double random_B() {
		double value;
		value = (int) (BF_HEIGHT_SQUARE * BF_WIDTH_SQUARE * (((double) AMOUNT_RANDOM_B_OF_PERCENT / 100)));
		return value;
	}

	int random(int k) {
		Random r = new Random();
		int i;
		i = r.nextInt(k);
		return i;
	}

	void clean() throws Exception {
		for (int i = 1; i < battleField.length + 1; i++) {
			moveToQuadrant(i, 1);
			scanTargetRight();
		}

	}

	boolean processInterception() {
		String position = getQuadrant(bulletX, bulletY);
		int indexVertikal = indexVertikal(position);
		int indexHorizontal = indexHorizontal(position);
		if (errorInterception(indexVertikal, indexHorizontal) == true) {
			for (int i = 0; i < bulletX || i < bulletY; i++) {
				if (equalsB(indexVertikal, indexHorizontal) == true) {
					renameSquareOnEmpty(indexVertikal, indexHorizontal);
					return true;
				}
			}
		}
		return false;
	}

	boolean errorInterception(int indexVertikal, int indexHorizontal) {
		if (indexHorizontal < (BF_WIDTH / SQUARE_SIZE_X) && indexHorizontal >= BORDER_HORIZONT_LEFT
				&& indexVertikal < (BF_HEIGHT / SQUARE_SIZE_Y) && indexVertikal >= BORDER_VERTIKAL_LEFT) {
			return true;
		}
		return false;
	}

	void renameSquareOnEmpty(int indexVertikal, int indexHorizontal) {
		battleField[indexVertikal][indexHorizontal] = " ";
	}

	boolean equalsB(int indexVertikal, int indexHorizontal) {
		if (battleField[indexVertikal][indexHorizontal].equals("B")) {
			return true;
		}
		return false;
	}

	String getQuadrant(int x, int y) {
		int xQuadrant = x / SQUARE_SIZE_X;
		int yQuadrant = y / SQUARE_SIZE_Y;
		String rezult = Integer.toString(yQuadrant) + "_" + Integer.toString(xQuadrant);
		return rezult;
	}

	int getCoordinatesX() {
		int CoordinatesX = tankX / SQUARE_SIZE_X;
		return CoordinatesX;
	}

	int getCoordinatesY() {
		int CoordinatesY = tankY / SQUARE_SIZE_Y;
		return CoordinatesY;
	}

	int indexVertikal(String position) {
		int indexVertikal = new Integer(position.substring(0, position.indexOf("_")));
		return indexVertikal;
	}

	int indexHorizontal(String position) {
		int indexHorizontal = new Integer(position.substring(position.indexOf("_") + 1, position.length()));
		return indexHorizontal;
	}

	String getQuadrantXY(int v, int h) {
		return (v - 1) * SQUARE_SIZE_Y + "_" + (h - 1) * SQUARE_SIZE_X;
	}

	void fire() throws Exception {
		System.out.println("Shooter, fire!!!");
		int direction = tankDirection;
		turn(direction);
		bulletX = tankX + BULLET_IPHEAVAL;
		bulletY = tankY + BULLET_IPHEAVAL;
		int step = STEP;
		int covered = 0;
		int bulletBorder = 0;

		if (direction == TOP) {
			bulletBorder = bulletBorder(direction);
		} else if (direction == BOTTOM) {
			bulletBorder = bulletBorder(direction);
		} else if (direction == LEFT) {
			bulletBorder = bulletBorder(direction);
		} else if (direction == RIGHT) {
			bulletBorder = bulletBorder(direction);
		}

		while (covered < bulletBorder) {
			if (direction == TOP) {
				bulletY -= step;
				if (processInterception() == true) {
					bulletBorder = BULLET_BORDER;
				}
			} else if (direction == BOTTOM) {
				bulletY += step;
				if (processInterception() == true) {
					bulletBorder = BULLET_BORDER;
				}
			} else if (direction == LEFT) {
				bulletX -= step;
				if (processInterception() == true) {
					bulletBorder = BULLET_BORDER;
				}
			} else {
				bulletX += step;
				if (processInterception() == true) {
					bulletBorder = BULLET_BORDER;
				}
			}
			covered += step;
			repaint();
			Thread.sleep(bulletSpeed);
		}
		bulletY = -100;
		bulletX = -100;
		repaint();

	}

	int bulletBorder(int direction) {
		int bulletBorder = 0;
		if (direction == TOP) {
			bulletBorder = tankY + BULLET_IPHEAVAL + BULLET_SIZE;
		} else if (direction == BOTTOM) {
			bulletBorder = BF_HEIGHT - tankY - BULLET_IPHEAVAL + BULLET_SIZE;
		} else if (direction == LEFT) {
			bulletBorder = tankX + BULLET_IPHEAVAL + BULLET_SIZE;
		} else if (direction == RIGHT) {
			bulletBorder = BF_WIDTH - tankX - BULLET_IPHEAVAL + BULLET_SIZE;
		}
		return bulletBorder;
	}

	void move(int direction) throws Exception {
		int covered = 0;
		errorBorders(direction);
		// check limits x: 0, 513; y: 0, 513
		turn(direction);
		while (covered < SQUARE_SIZE_Y) {
			if (direction == TOP) {
				scanTargetTop();
				tankY -= STEP;
			} else if (direction == BOTTOM) {
				scanTargetBottom();
				tankY += STEP;
			} else if (direction == LEFT) {
				scanTargetLeft();
				tankX -= STEP;
			} else {
				scanTargetRight();
				tankX += STEP;
			}
			covered += STEP;
			repaint();
			Thread.sleep(speed);
		}
	}

	void errorBorders(int direction) {
		if ((direction == TOP && tankY == BORDER_VERTIKAL_LEFT)
				|| (direction == BOTTOM && tankY >= (BF_HEIGHT - SQUARE_SIZE_Y))
				|| (direction == LEFT && tankX == BORDER_HORIZONT_LEFT)
				|| (direction == RIGHT && tankX >= (BF_WIDTH - SQUARE_SIZE_X))) {
			System.out.println("Error coordinates");
			System.exit(0);
		}
	}

	void scanTargetTop() throws Exception {
		int indexHorizontal = getCoordinatesX();
		tankDirection = TOP;
		for (int i = tankY; i > -SQUARE_SIZE_Y; i -= SQUARE_SIZE_Y) {
			int indexVertikal = (i / SQUARE_SIZE_Y);
			if (equalsB(indexVertikal, indexHorizontal) == true) {
				System.out.println("We have target!");
				fire();
			}
		}
	}

	void scanTargetBottom() throws Exception {
		int indexHorizontal = getCoordinatesX();
		tankDirection = BOTTOM;
		for (int i = tankY; i < BF_HEIGHT; i += SQUARE_SIZE_Y) {
			int indexVertikal = (i / SQUARE_SIZE_Y);
			if (equalsB(indexVertikal, indexHorizontal) == true) {
				System.out.println("We have target!");
				fire();
			}
		}
	}

	void scanTargetLeft() throws Exception {
		int indexVertikal = getCoordinatesY();
		tankDirection = LEFT;
		for (int i = tankX; i > -SQUARE_SIZE_X; i -= SQUARE_SIZE_X) {
			int indexHorizontal = (i / SQUARE_SIZE_X);
			if (equalsB(indexVertikal, indexHorizontal) == true) {
				System.out.println("We have target!");
				fire();
			}
		}
	}

	void scanTargetRight() throws Exception {
		int indexVertikal = getCoordinatesY();
		tankDirection = RIGHT;
		for (int i = tankX; i < (BF_WIDTH); i += SQUARE_SIZE_X) {
			int indexHorizontal = (i / SQUARE_SIZE_X);
			if (equalsB(indexVertikal, indexHorizontal) == true) {
				System.out.println("We have target!");
				fire();
			}
		}
	}

	void turn(int direction) {
		if (tankDirection != direction) {
			tankDirection = direction;
		}
	}

	void moveRandom() throws Exception {
		Random r = new Random();
		int i;
		while (true) {
			i = r.nextInt(5);
			if (i > 0) {
				move(i);
			}
		}
	}

	void moveToQuadrant(int v, int h) throws Exception {
		String coordinates = getQuadrantXY(v, h);
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));
		System.out.println("Driver! We have a route! Coordinates " + "Vertikal " + ((y / SQUARE_SIZE_Y) + 1) + " "
				+ "Horizontal " + ((x / SQUARE_SIZE_X) + 1) + " Go, go, go!");
		if (tankX < x) {
			while (tankX != x) {
				move(RIGHT);
			}
		} else {
			while (tankX != x) {
				move(LEFT);
			}
		}

		if (tankY < y) {
			while (tankY != y) {
				move(BOTTOM);
			}
		} else {
			while (tankY != y) {
				move(TOP);
			}
		}
	}

	// Magic bellow. Do not worry about this now, you will understand everything
	// in this course.
	// Please concentrate on your tasks only.

	public static void main(String[] args) throws Exception {
//		tank bf = new tank();
//		bf.runTheGame();
	}

	public tank() throws Exception {
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(450, 50);
		frame.setMinimumSize(new Dimension(BF_WIDTH + 18, BF_HEIGHT + 22 + 18));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int i = 0;
		Color cc;
		for (int v = 0; v < BF_HEIGHT_SQUARE; v++) {
			for (int h = 0; h < BF_WIDTH_SQUARE; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField[j].length; k++) {
				if (battleField[j][k].equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates.substring(0, separator));
					int x = Integer.parseInt(coordinates.substring(separator + 1));
					g.setColor(new Color(144, 77, 48));
					g.fillRect(x, y, SQUARE_SIZE_X, SQUARE_SIZE_Y);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x, y+(SQUARE_SIZE_Y/4), SQUARE_SIZE_X, SQUARE_SIZE_Y/30);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x, y+(SQUARE_SIZE_Y/4*2), SQUARE_SIZE_X, SQUARE_SIZE_Y/30);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x, y+(SQUARE_SIZE_Y/4*3), SQUARE_SIZE_X, SQUARE_SIZE_Y/30);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x, y+(SQUARE_SIZE_Y/4*4-SQUARE_SIZE_Y/30), SQUARE_SIZE_X, SQUARE_SIZE_Y/30);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X/3, y, SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+(SQUARE_SIZE_X/3*2)+SQUARE_SIZE_X/6, y, SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X/2, y+(SQUARE_SIZE_Y/4), SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X, y+(SQUARE_SIZE_Y/4), SQUARE_SIZE_X/30-64/15, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X/3, y+(SQUARE_SIZE_Y/4*2), SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+(SQUARE_SIZE_X/3*2)+SQUARE_SIZE_X/6, y+(SQUARE_SIZE_Y/4*2), SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X/2, y+(SQUARE_SIZE_Y/4*3), SQUARE_SIZE_X/30, SQUARE_SIZE_Y/3-64/12);
					g.setColor(new Color(0, 0, 25));
					g.fillRect(x+SQUARE_SIZE_X, y+(SQUARE_SIZE_Y/4*3), SQUARE_SIZE_X/30-64/15, SQUARE_SIZE_Y/3-64/15);
				}
			}
		}

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tankX, tankY, SQUARE_SIZE_X, SQUARE_SIZE_Y);

		g.setColor(new Color(0, 255, 0));
		if (tankDirection == TOP) {
			g.fillRect(tankX + (20/ratio), tankY, 24/ratio, 34/ratio);
		} else if (tankDirection == BOTTOM) {
			g.fillRect(tankX + (20/ratio), tankY + 30/ratio, 24/ratio, 34/ratio);
		} else if (tankDirection == LEFT) {
			g.fillRect(tankX, tankY + 20/ratio, 34/ratio, 24/ratio);
		} else {
			g.fillRect(tankX + 30/ratio, tankY + 20/ratio, 34/ratio, 24/ratio);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bulletX, bulletY, 14/ratio, 14/ratio);
	}

}