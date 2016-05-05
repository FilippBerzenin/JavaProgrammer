package Lesson_1.frame_5.TankLauncher;

import java.util.Random;

public class Tank {

    private final int speed = 10;

    private int x;
    private int y;

    // 1 - up, 2- down, 3 - left, 4 - right
    private int direction;

    private int TOP = 1;
    private int BOTTOM = 2;
    private int LEFT = 3;
    private int RIGHT = 4;

    private int STEP = 1;

    private ActionField af;
    private BattelField bf;

    public Tank (ActionField af, BattelField bf) {
        this(af, bf, 128, 512, 1);
    }

    public Tank (ActionField af, BattelField bf, int x, int y, int direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turn (int direction)throws Exception  {
        this.direction = direction;
        af.processTurn(this);
    }

    public void move () throws Exception {
        af.processMove(this);
    }

    public void fire () throws Exception {
        Bullet bullet = new Bullet(x+25, y+25, direction);
        af.processFire(bullet);
    }

    public void moveRandom()throws Exception  {
        Random r = new Random();
        int i;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                turn(i);
                move();
            }
        }
    }

    public void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = af.getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        System.out.println("Driver! We have a route! Coordinates " + "Vertikal " + v + " "
                + "Horizontal " + h + " Go, go, go!");
        if (this.x < x) {
            turn(RIGHT);
            while (this.x != x) {
                move();
            }
        } else {
            turn(LEFT);
            while (this.x != x) {
                move();
            }
        }
        if (this.y < y) {
            turn(BOTTOM);
            while (this.y != y) {
                move();
            }
        } else {
            turn(TOP);
            while (this.y != y) {
                move();
            }
        }
    }


    public void clean ()throws Exception  {
        for (int i = 1; i < bf.battleField.length + 1; i++) {
            moveToQuadrant(i, 1);
//            af.scanTargetTop();
//            af.scanTargetLeft();
//            af.scanTargetBottom();
            af.scanTargetRight();
        }
    }

    public int getX() {
        return x;
    }

    public void updateX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getTOP() {
        return TOP;
    }

    public int getBOTTOM() {
        return BOTTOM;
    }

    public int getLEFT() {
        return LEFT;
    }

    public int getRIGHT() {
        return RIGHT;
    }

    public int getSTEP() {
        return STEP;
    }

    public int getSpeed() {
        return speed;
    }
}
