package Lesson_3.Frame_2.shapes;


import java.awt.*;

public class Triangle extends Shape {

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));

        g.setColor(new Color(0, 0, 255));
        g.fillPolygon(new int[] {450, 400, 500}, new int[] {100, 200, 200}, 3);
    }
}
