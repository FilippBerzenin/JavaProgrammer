package Lesson_3.Frame_3.Tank.Objects.Fields;

import Lesson_3.Frame_3.Tank.Code.Field;
import Lesson_3.Frame_3.Tank.Code.Utilites;

import java.awt.*;

public class Brick extends Field {

    public Brick(int x, int y, Graphics g) {
        super(x, y, g);
    }

    @Override
    public void draw(Graphics g) {
        color = new Color(150, 50, 50);
        super.draw(g);
    }

}
