package Lesson_5.Frame_4.tank.tanks;

import Lesson_5.Frame_4.tank.enums.Direction;
import Lesson_5.Frame_4.tank.BattleField;
import Lesson_5.Frame_4.tank.bf.Blank;
import Lesson_5.Frame_4.tank.bf.Eagle;
import Lesson_5.Frame_4.tank.bf.Rock;
import Lesson_5.Frame_4.tank.enums.Action;

import java.awt.*;
import java.util.ArrayList;

public class BT7 extends AbstractTank {

	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		IMAGE_NAME = "BT7.png";
		firstMethod ();
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		IMAGE_NAME = "BT7.png";
		firstMethod ();
	}

	private Action slideForGoal () {
		if (targetCoordinates()) {
			return Action.FIRE;
		}
		int tankY = this.getY()/64;
		int tankX = this.getX()/64;
		if (this.getDirection().equals(Direction.RIGHT)) {
			if (tankY>0 && bf.scanQuadrant(tankY-1, tankX) instanceof Blank) {
				turn(Direction.UP);
			}
			else if (tankX<8 && bf.scanQuadrant(tankY, tankX+1) instanceof Blank) {
				turn(Direction.RIGHT);
			}
			else if (tankY<8 && bf.scanQuadrant(tankY+1, tankX) instanceof Blank) {
				turn(Direction.DOWN);
			}
			else if (tankX>0 && bf.scanQuadrant(tankY, tankX-1) instanceof Blank) {
				turn(Direction.LEFT);
			}
			return Action.MOVE;
		}
		else if (this.getDirection().equals(Direction.DOWN)) {
			if (tankX<8 && bf.scanQuadrant(tankY, tankX+1) instanceof Blank) {
				turn(Direction.RIGHT);
			}
			else if (tankY<8 && bf.scanQuadrant(tankY+1, tankX) instanceof Blank) {
				turn(Direction.DOWN);
			}
			else if (tankX>0 && bf.scanQuadrant(tankY, tankX-1) instanceof Blank) {
				turn(Direction.LEFT);
			}
			else if (tankY>0 && bf.scanQuadrant(tankY-1, tankX) instanceof Blank) {
				turn(Direction.UP);
			}
			return Action.MOVE;
		}
		else if (this.getDirection().equals(Direction.LEFT)) {
			if (tankY<8 && bf.scanQuadrant(tankY+1, tankX) instanceof Blank) {
				turn(Direction.DOWN);
			}
			else if (tankX>0 && bf.scanQuadrant(tankY, tankX-1) instanceof Blank) {
				turn(Direction.LEFT);
			}
			else if (tankY>0 && bf.scanQuadrant(tankY-1, tankX) instanceof Blank) {
				turn(Direction.UP);
			}
			else if (tankX<8 && bf.scanQuadrant(tankY, tankX+1) instanceof Blank) {
				turn(Direction.RIGHT);
			}
			return Action.MOVE;
		}
		else if (this.getDirection().equals(Direction.UP)) {
			if (tankX>0 && bf.scanQuadrant(tankY, tankX-1) instanceof Blank) {
				turn(Direction.LEFT);
			}
			else if (tankY>0 && bf.scanQuadrant(tankY-1, tankX) instanceof Blank) {
				turn(Direction.UP);
			}
			else if (tankY<8 && bf.scanQuadrant(tankY, tankX+1) instanceof Blank) {
				turn(Direction.RIGHT);
			}
			else if (tankX<8 && bf.scanQuadrant(tankY+1, tankX) instanceof Blank) {
				turn(Direction.DOWN);
			}
		}
		return Action.MOVE;
	}

	private boolean targetCoordinates () {
		int[] eagleLocation = locationOfEagle();
		int eagleX = eagleLocation[1];
		int eagleY = eagleLocation[0];
//		for (int i = 0;i<bf.getBfHeight()/64;i++) {
//			for (int k = 0; k<bf.getBfWidth()/64;k++) {
//				if (bf.scanQuadrant(i, k) instanceof Eagle) {
//					eagleY = i;
//					eagleX = k;
//				}
//			}
//		}
		if (eagleY == this.getY()/64) {
			if (eagleX > this.getX()/64) {
				for (int i = eagleX-1; i > this.getX()/64; i--) {
					if ((bf.scanQuadrant(this.getY()/64, i) instanceof Rock)) {
						return false;
					}
				}
					turn(Direction.RIGHT);
					return true;
			}
			else if (eagleX < this.getX()/64) {
				for (int i = eagleX + 1; i < this.getX() / 64; i++) {
					if ((bf.scanQuadrant(this.getY() / 64, i) instanceof Rock)) {
						return false;
					}
				}
					turn(Direction.LEFT);
					return true;
			}
		}
		if (eagleX == this.getX()/64) {
			if (eagleY > this.getY()/64) {
				for (int i = eagleY - 1; i > this.getY() / 64; i--) {
					if ((bf.scanQuadrant(i, this.getX() / 64) instanceof Rock)) {
						return false;
					}
				}
					turn(Direction.DOWN);
					return true;
			}
			if (eagleY < this.getY()/64) {
				for (int i = eagleY; i < this.getY() / 64; i++) {
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
		int[] eagleLocation = new int[2];
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

	private String[][] wayFrom = bf.getBattleFieldTemplate();

	private boolean impasse (int y, int x, int yNew, int xNew ) {
		if ((y+1<9 && y+1 == this.getY()/64 && x == this.getX()/64) || (y-1>=0 && y-1 == this.getY()/64 && x == this.getX()/64) ||
				(x+1<9 && x+1 == this.getY()/64 && x+1 == this.getX()/64) || (x+1<9 && x-1 == this.getY()/64 && x-1 == this.getX()/64)) {
			return true;
		}
		if (y < yNew && x == xNew) {
			if (((x+1)<9 && bf.scanQuadrant(yNew, x+1) instanceof Blank) ||
					((x-1)>=0 && bf.scanQuadrant(yNew, x-1) instanceof Blank) ||
					((yNew+1)<9 && bf.scanQuadrant(yNew+1, x) instanceof Blank) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
					return true;
			}
		}
		else if (y > yNew && x == xNew) {
				if (((x+1)<9 && bf.scanQuadrant(yNew, x+1) instanceof Blank) ||
						((x-1)>=0 && bf.scanQuadrant(yNew, x-1) instanceof Blank) ||
						((yNew-1)>=0 && bf.scanQuadrant(yNew-1, x) instanceof Blank) ||
						yNew==this.getY()/64 && x==this.getX()/64) {
					return true;
				}
		}
		else if (y == yNew && x > xNew) {
			if (((y+1)<9 && bf.scanQuadrant(y+1, xNew) instanceof Blank) ||
					((y-1)>=0 && bf.scanQuadrant(y-1, xNew) instanceof Blank) ||
					((xNew-1)>=0 && bf.scanQuadrant(y, xNew-1) instanceof Blank) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		else if (y == yNew && x < xNew) {
			if (((y+1)<9 && bf.scanQuadrant(y+1, xNew) instanceof Blank) ||
					((y-1)>=0 && bf.scanQuadrant(y-1, xNew) instanceof Blank) ||
					((xNew+1)<9 && bf.scanQuadrant(y, xNew+1) instanceof Blank) ||
					yNew==this.getY()/64 && x==this.getX()/64) {
				return true;
			}
		}
		return false;
	}

	private Direction[] fillDirection (int x, int y) {
		Direction[] dir = new Direction[5];
		if (x>=0 && x <9 && y>=0 && y<9) {
			if (x < 8 && bf.scanQuadrant(y, x + 1) instanceof Blank && wayFrom[y][x+1] != "N" && !wayFrom[y][x + 1].equals("G")) {
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
			if (x > 0 && bf.scanQuadrant(y, x - 1) instanceof Blank && wayFrom[y][x-1] != "N" && !wayFrom[y][x - 1].equals("G")) {
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
			if (y > 0 && bf.scanQuadrant(y-1, x) instanceof Blank && wayFrom[y-1][x] != "N" && !wayFrom[y - 1][x].equals("G")) {
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
			if (y < 8 && bf.scanQuadrant(y+1, x) instanceof Blank && wayFrom[y+1][x] != "N" && !wayFrom[y + 1][x].equals("G")) {
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

	private Direction[] mainDirection (Direction[] dir, int y, int x) {
		int right;
		int left;
		int up;
		int down;
//		System.out.println(Arrays.toString(dir));
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
//		if ((distanceForTank(y, x, y, x+1) || tupik(Direction.RIGHT, y, x)) && impasse(y,x,y,x+1)) {
//					wayFrom[y][x + 1] = "G";
//					dir[4] = Direction.RIGHT;
//				}
//						if ((distanceForTank(y, x, y, x-1) || tupik(Direction.RIGHT, y, x)) && impasse(y,x,y,x-1)) {
//					wayFrom[y][x - 1] = "G";
//					dir[4] = Direction.LEFT;
//				}
//						if ((distanceForTank(y, x, y-1, x) || tupik(Direction.RIGHT, y, x)) && impasse(y,x,y-1,x)) {
//					dir[4] = Direction.UP;
//					wayFrom[y-1][x] = "G";
//				}
//						if ((distanceForTank(y, x, y+1, x) || tupik(Direction.RIGHT, y, x)) && impasse(y,x,y+1,x)) {
//					dir[4] = Direction.DOWN;
//					wayFrom[y+1][x] = "G";
//				}
		return  dir;
	}

	private boolean tupik (Direction dir, int y, int x) {
		int i = way.size()-1;

//
//		x<8 && x>0 && y<8 && y>0 && (distanceForTank(y, x, y-1, x) && y>0)  || (y>0 && (impasse(y,x,y-1,x))  && (
//				((x>0 && wayFrom[y][x-1] == "N") || !(x>0 && bf.scanQuadrant(y, x - 1) instanceof Blank)) &&
//						((x<8 && wayFrom[y][x+1] == "N") || (x<8 && !(bf.scanQuadrant(y, x+1) instanceof Blank))) &&
//						((y<8 && wayFrom[y+1][x] == "N") || (y<8 && !(y<8 && bf.scanQuadrant(y+1, x) instanceof Blank))
//						)))

		if (dir == Direction.RIGHT) {

		}
		else if (dir == Direction.LEFT) {

		}
		else if (dir == Direction.UP) {

		}
		else if (dir == Direction.DOWN) {

		}

		return true;
	}

	private void correctWay (Direction[] dir, int y, int x) {
		int siseArray = way.size();
		for (int i = way.size()-1; i>=0; i--) {
			for (int k = 0; k<5; k++) {
				if (way.get(i).getWayD()[4].equals(way.get(i).getWayD()[k])) {
					way.get(i).getWayD()[k] = null;
					wayFrom[y][x] = "N";
					for (int h = 0; h<5; h++) {
						if (way.get(i).getWayD()[h] != null) {
							way.get(i).getWayD()[4] = way.get(i).getWayD()[h];
						}
					}
					siseArray = i;
				}
			}
		}
//		if (way.get(way.size()-1).wayD[4].equals(Direction.UP)) {
//			dir[4] = Direction.DOWN;
//			wayFrom[y][x] = "N";
//		}
		indexWay = siseArray;
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

	ArrayList <position> way = new ArrayList<>();

	int indexWay = 0;

	int[] eagleLocation = locationOfEagle();
	int eagleX = eagleLocation[1];
	int eagleY = eagleLocation[0];
	int wayX = eagleX;
	int wayY = eagleY;

	private void fillArrays (int tankY, int tankX) {
		int[] eagleLocation = locationOfEagle();
		int eagleX = eagleLocation[1];
		int eagleY = eagleLocation[0];
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
//			}
		}
	}

	private void firstMethod () {
		locationOfEagle ();
//		while (true) {
//			if (way.get(way.size()-1).y == this.getY()/64 && way.get(way.size()-1).x == this.getX()/64) {
//				break;
//			}
			fillArrays(this.getY() / 64, this.getX() / 64);
//		}
	}



	private Action actionTank() {

		if (targetCoordinates() == true) {
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

	@Override
	public Action setUp() {
		Action stepQ;
//		stepQ  = actionTank();
		stepQ = Action.FIRE;
		return stepQ;
	}
}
