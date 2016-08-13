package Lesson_3.Frame_3.Tank.Objects.Tanks;

import Lesson_3.Frame_3.Tank.ActionField;
import Lesson_3.Frame_3.Tank.BattelField;
import Lesson_3.Frame_3.Tank.Objects.Enum.Direction;


import java.awt.*;

public class T34 extends AbstractTank {
    public T34(ActionField af, BattelField bf) {
        super(af, bf);
        tankColor = new Color (0, 255, 0);
        towerColor = new Color (255, 0, 0);

    }

    public T34(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        tankColor = new Color (0, 255, 0);
        towerColor = new Color (255, 0, 0);
    }

    @Override
    public void Destroy() {
        super.Destroy();
    }
}
