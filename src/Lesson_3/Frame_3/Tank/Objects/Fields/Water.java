package Lesson_3.Frame_3.Tank.Objects.Fields;

import Lesson_3.Frame_3.Tank.Code.Field;

import java.awt.*;

public class Water extends Field{

    public Water(int x, int y, Graphics g) {
        super(x, y, g);
    }

    @Override
    public void draw(Graphics g) {
        color = new Color(0, 0, 255);
        super.draw(g);
    }
}
