package Lesson_3.Frame_3.Tank;

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
    public String toString() {
        return "BT7 ";
    }
}
