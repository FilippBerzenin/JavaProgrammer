package Lesson_5.Frame_5.Tank.tanks;
import Lesson_5.Frame_5.Tank.BattleField;
import Lesson_5.Frame_5.Tank.enums.Action;
import Lesson_5.Frame_5.Tank.enums.Direction;

import java.awt.*;

public class Tiger extends AbstractTank {
	
	private int armor;
	
	public Tiger(BattleField bf) {
		super(bf);
		IMAGE_NAME = "Tiger.png";
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		armor = 1;
	}
	
	public Tiger(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		IMAGE_NAME = "Tiger.png";
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		armor = 1;
	}
	
	@Override
	public void destroy() {
		if (armor > 0) {
			armor--;
		} else {
			super.destroy();
		}
	}
	
	@Override
	public Action setUp() {
		Action stepQ;
		stepQ  = actionTank();
		return stepQ;
	}
}
