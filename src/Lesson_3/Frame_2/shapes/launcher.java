package Lesson_3.Frame_2.shapes;

public class launcher {

    public static void main(String[] args) {

//        Shape s = new Shape();
        Circle c = new Circle();
        Rectangle r = new Rectangle();
        Triangle t = new Triangle();

        Shape[] s = new Shape[3];
        s[0] = c;
//        s[1] = r;
//        s[2] = t;
        ShapesTemplite st;
        st = new ShapesTemplite(s);
    }
}
