package Lesson_4.Frame_4.NewTank;

import java.awt.*;

public class Tiger extends AbstractTank {

	private int armor;

	public Tiger(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
		armor = 1;
	}

	public Tiger(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
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
		return Action.FIRE;
	}

	@Override
	public void moveToEagle() {

	}
}
