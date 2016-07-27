package Lesson_3.Frame_2.shapes;

import Lesson_3.Frame_2.shapes.Glyph.Drawable;
import java.awt.*;

public abstract class Shape implements Drawable {

    protected Color color;

//    protected void setStroce () {
////        Graphics2D g2d = (Graphics2D) g;
////        g2d.setStroke(new BasicStroke(5));
//    }

//    public abstract void draw(Graphics g);
//    {
//        throw new IllegalStateException("I dont now how to paint this shape. Please, owerride me");
//    }

    public String newMethod() {
        return toString();
        }
}
