package Lesson_3.Frame_2.shapes.Glyph;

public class roundGlyph extends glyph {

    private int radius = 5;

    public roundGlyph (int radius) {
        System.out.println("RoundGlyph#condtracor");
        draw();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("RoundGlyph#Draw()");
        System.out.println("RoundGlyph#radius " + radius);
    }
}
