package Lesson_3.Frame_2.shapes;

import java.awt.*;

public class Circle extends Shape {


    @Override
    public String newMethod() {
        return "Circle";
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));

        g.setColor(new Color(0, 255, 0));
        g.fillOval(100, 100, 100, 100);
    }
}
