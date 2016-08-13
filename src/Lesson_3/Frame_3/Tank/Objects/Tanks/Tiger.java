package Lesson_3.Frame_3.Tank.Objects.Tanks;

import Lesson_3.Frame_3.Tank.BattelField;
import Lesson_3.Frame_3.Tank.Objects.Enum.Direction;
import Lesson_3.Frame_3.Tank.ActionField;

import java.awt.*;

public class Tiger extends AbstractTank {

    public Tiger(ActionField af, BattelField bf) {
        super(af, bf);
        armor = 1;
        tankColor = new Color (255, 0, 0);
        towerColor = new Color (0, 255, 0);
    }

    public Tiger(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
        tankColor = new Color (255, 0, 0);
        towerColor = new Color (0, 255, 0);
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
