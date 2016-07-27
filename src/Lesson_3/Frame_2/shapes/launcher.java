package Lesson_3.Frame_2.shapes;

//import Lesson_3.Frame_2.shapes.Glyph;
import Lesson_3.Frame_2.shapes.Glyph.Drawable;

public class launcher {

    public static void main(String[] args) {

//        Shape s = new Shape();
//        Circle c = new Circle();
//        Rectangle r = new Rectangle();
//        Triangle t = new Triangle();
//
        Drawable[] s = new Drawable[] {
                new Circle(),
                new Rectangle(),
                new Triangle(),
                new Square()
        };
        new ShapesTemplite(s);
    }
}
