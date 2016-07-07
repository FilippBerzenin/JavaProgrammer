package Lesson_3.Frame_2.shapes;

public class launcher {

    public static void main(String[] args) {

//        Shape s = new Shape();
//        Circle c = new Circle();
//        Rectangle r = new Rectangle();
//        Triangle t = new Triangle();
//
        Shape[] s = new Shape[] {
                new Circle(),
                new Rectangle(),
                new Triangle(),
                new Square()
        };
        new ShapesTemplite(s);
    }
}
