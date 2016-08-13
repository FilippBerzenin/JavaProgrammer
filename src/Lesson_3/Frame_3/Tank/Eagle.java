package Lesson_3.Frame_3.Tank;

import Lesson_3.Frame_3.Tank.Code.Field;

import java.awt.*;

public class Eagle  extends Field {

    protected Eagle(int x, int y, Graphics g) {
        super(x, y, g);
    }

    @Override
    public void draw(Graphics g) {
        color = new Color(100, 100, 150);
        super.draw(g);
    }
}
