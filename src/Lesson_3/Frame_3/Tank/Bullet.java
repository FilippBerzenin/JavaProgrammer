package Lesson_3.Frame_3.Tank;

import java.awt.*;

public class Bullet implements Drawable, Destroyable {

    private final int speed = 5;
    private int x = 0;
    private int y = 0;
    private Direction dirction;
    private int STEP = 1;
    private int BULLET_SIZE = 14;
    private int BULLET_BORDER = 26;
    private int BULLET_IPHEAVAL = 25;


    public Bullet (int x, int y, Direction dirction) {
        this.x = x;
        this.y = y;
        this.dirction = dirction;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(this.getX(), this.getY(), 14, 14);

    }

    @Override
    public void Destroy() {
        x = -100;
        y = -100;

    }

    public void updateX (int x) {
        this.x += x;
    }

    public void updateY (int y) {
        this.y += y;
    }

    public void destroy () {
        x = -100;
        y = -100;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirction() {
        return dirction;
    }

    public int getSTEP() {
        return STEP;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBULLET_SIZE() {
        return BULLET_SIZE;
    }

    public int getBULLET_BORDER() {
        return BULLET_BORDER;
    }

    public int getBULLET_IPHEAVAL() {
        return BULLET_IPHEAVAL;
    }
}
