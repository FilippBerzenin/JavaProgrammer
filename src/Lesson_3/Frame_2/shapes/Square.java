package Lesson_3.Frame_2.shapes;

import java.awt.*;

public class Square extends Shape {

    public Square() {
       color=new Color(50,150,20);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));

        g.setColor(color);
        g.drawPolygon(new int [] {250, 250, 350, 350}, new int[] {320, 220, 220, 320}, 4);
    }
}
