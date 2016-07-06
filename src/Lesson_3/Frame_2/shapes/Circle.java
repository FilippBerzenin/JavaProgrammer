package Lesson_3.Frame_2.shapes;

import java.awt.*;

public class Circle extends Shape {


    @Override
    public String newMethod() {
        return "Circle";
    }

    @Override
    public void draw(Graphics g) {
        drawOval(10, 10, 10, 10);
    }

    public void drawOval (int x, int y, int width, int height) {

    }
}
