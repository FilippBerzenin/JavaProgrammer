package Lesson_5.Frame_4.tank.tanks;

import Lesson_5.Frame_4.tank.enums.Direction;
import Lesson_5.Frame_4.tank.BattleField;
import Lesson_5.Frame_4.tank.enums.Action;

import java.awt.*;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf) {
		super(bf, 128, 512, Direction.UP);
		IMAGE_NAME = "T34.png";
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(255, 0, 0);
	}
	
	public T34(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		IMAGE_NAME = "T34.png";
		tankColor = new Color(0, 255, 0);
		towerColor = new Color(255, 0, 0);
	}

	private Object[] actoins = new Object[] {
			Action.NONE
//		Direction.RIGHT,
//		Action.FIRE,
//		Action.MOVE,
//		Action.FIRE,
//		Action.MOVE,
//		Action.FIRE,
//		Action.FIRE
	};
	
	private int step = 0;
	
	@Override
	public Action setUp() {
		if (step >= actoins.length) {
			step = 0;
		}
		if (!(actoins[step] instanceof Action)) {
			turn((Direction) actoins[step++]);
		}
		if (step >= actoins.length) {
			step = 0;
		}
		return (Action) actoins[step++];
	}
}
