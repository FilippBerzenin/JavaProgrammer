package Lesson_3.Frame_3.Tank;

import Lesson_3.Frame_3.Tank.Code.Field;

import java.awt.*;

public class Rock extends Field {

    Rock(int x, int y, Graphics g) {
        super(x, y, g);
    }

    @Override
    public void draw(Graphics g) {
        color = new Color(0, 0, 0);
        super.draw(g);
    }
}
