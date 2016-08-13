package Lesson_3.Frame_3.Tank.Objects.Tanks;

import Lesson_3.Frame_3.Tank.ActionField;
import Lesson_3.Frame_3.Tank.BattelField;
import Lesson_3.Frame_3.Tank.Objects.Enum.Direction;

import java.awt.*;

public class BT7 extends AbstractTank {

    public BT7(ActionField af, BattelField bf) {
        super(af, bf);
        speed = speed/2;
    }

    public BT7(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed = speed/2;
    }
//
//        @Override
//        public void setSpeed(int speed) {
//            super.setSpeed(5);
//        }


    @Override
    public void Destroy() {
        super.Destroy();
    }

    @Override
    public void draw(Graphics g) {
        // defender
        g.setColor(new Color(0, 255, 0));
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(new Color(255, 0, 0));
        if (this.getDirection() == Direction.TOP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.BOTTOM) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }

    @Override
    public String toString() {
        return "BT7 ";
    }
}
