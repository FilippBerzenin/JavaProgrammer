package Lesson_3.Frame_2.shapes;

import java.awt.*;

public class Square extends Shape {

    @Override
    public void draw(Graphics g) {

        g.setColor(new Color(50,150,20));
        g.drawPolygon(new int [] {250, 250, 350, 350}, new int[] {320, 220, 220, 320}, 4);
    }
}
