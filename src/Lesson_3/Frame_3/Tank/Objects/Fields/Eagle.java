package Lesson_3.Frame_3.Tank.Objects.Fields;

import Lesson_3.Frame_3.Tank.Code.Field;

import java.awt.*;

public class Eagle  extends Field {

    public Eagle(int x, int y, Graphics g) {
        super(x, y, g);
    }

    @Override
    public void draw(Graphics g) {
        color = new Color(100, 100, 150);
        super.draw(g);
    }
}
