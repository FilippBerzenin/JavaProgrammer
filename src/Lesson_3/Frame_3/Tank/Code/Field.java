package Lesson_3.Frame_3.Tank.Code;

import Lesson_3.Frame_3.Tank.Interface.Destroyable;
import Lesson_3.Frame_3.Tank.Interface.Drawable;

import java.awt.*;

public abstract class Field implements Drawable, Destroyable {

    protected int x;
    protected int y;

    protected Color color;

    protected Field(int x, int y, Graphics g) {
        this.x = x;
        this.y = y;
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 64, 64);
    }

    @Override
    public void Destroy() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
