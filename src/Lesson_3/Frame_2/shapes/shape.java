package Lesson_3.Frame_2.shapes;

import java.awt.Graphics;

public class Shape {

    public void draw(Graphics g) {
        throw new IllegalStateException("I dont now how to paint this shape. Please, owerride me");
    }

    public String newMethod() {
        return toString();
        }
}
