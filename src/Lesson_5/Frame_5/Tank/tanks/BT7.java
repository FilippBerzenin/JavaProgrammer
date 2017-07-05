package Lesson_5.Frame_5.Tank.tanks;
import Lesson_5.Frame_5.Tank.BattleField;
import Lesson_5.Frame_5.Tank.bf.Eagle;
import Lesson_5.Frame_5.Tank.enums.Action;
import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.interfaces.BFObject;

import java.awt.*;

public class BT7 extends AbstractTank {



	public BT7(BattleField bf) {
		super(bf);

		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		IMAGE_NAME = "BT7.png";
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);

		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		IMAGE_NAME = "BT7.png";
	}

	@Override
	public Action setUp() {

		Action stepQ;
		stepQ  = actionTank();
		return stepQ;
	}
}
