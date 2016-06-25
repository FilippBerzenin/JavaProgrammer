package Lesson_2.Frame_6.tank;

public class Tiger extends Tank {

    private int armor;


    public Tiger(ActionField af, BattelField bf) {
//        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattelField bf, int x, int y, Direction direction) {
 //       super(af, bf, x, y, direction);
        armor = 1;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
