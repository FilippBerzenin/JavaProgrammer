package Lesson_3.Frame_2.shapes;

import java.awt.*;

public class Rectangle extends Shape {


    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));

        g.setColor(new Color(255, 0, 0));
        g.fillRect(250, 100, 100, 100);

    }
}
