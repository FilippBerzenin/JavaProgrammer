package Lesson_4.Frame_4.NewTank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
	}

	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		movePath = 2;
	}


	public int[] eagleCoordintes () {
		int i = 0;
		int k  =0;
		int[] eagleCoordinates = new int[2];
		for (i = 0; i<9;i++) {
			for (k = 0; k<9;k++) {
				if (getBf().scanQuadrant(i,k) instanceof Eagle) {
//					System.out.println(i+" "+k +"eagle coordinates");
					eagleCoordinates[0] = i;
					eagleCoordinates[1] = k;
					return eagleCoordinates;
				}
			}
		}
		return null;
	}

	public void moveToEagle() {
//		Object go = null;
		int[] eagleCoordinates = eagleCoordintes ();
//		System.out.println(Arrays.toString(eagleCoordinates));
//		System.out.println(getX()/64+"Xcoord "+eagleCoordinates[1]+"Eagle X coord" +
//				getY()/64+"Ycoord "+eagleCoordinates[0]+"Eagle Y coord");
			if (getX()/64 < eagleCoordinates[1]) {
				acts.add(Direction.RIGHT);
				acts.add(Action.FIRE);
				acts.add(Action.MOVE);
			}
			else if (getX()/64 > eagleCoordinates[1]) {
				acts.add(Direction.LEFT);
				acts.add(Action.FIRE);
				acts.add(Action.MOVE);
				}
			else if (getX()/64 == eagleCoordinates[1] && getY()/64<eagleCoordinates[0]) {
				acts.add(Direction.DOWN);
				acts.add(Action.FIRE);
				acts.add(Action.MOVE);
			}
			else if (getX()/64 == eagleCoordinates[1] && getY()/64>eagleCoordinates[0]) {
				acts.add(Action.FIRE);
				acts.add(Direction.UP);
				acts.add(Action.MOVE);
			}
	}
//	private Object[] actoins = new Object[] {
//			Direction.RIGHT,
////		Action.FIRE,
//			Action.MOVE,
//			Action.FIRE,
//			Action.MOVE,
//			Action.FIRE,
//			Action.FIRE
//	};

	private ArrayList<Object> acts = new ArrayList<>();
	private int step = 0;

	@Override
	public Action setUp() {
		acts.clear();
		moveToEagle();
		System.out.println(acts);
		if (step >= acts.size()) {
			step = 0;
		}
		if (!(acts.get(step) instanceof Action)) {
			turn((Direction) acts.get(step++));
		}
		if (step >= acts.size()) {
			step = 0;
		}
		return (Action) acts.get(step++);
	}
}
