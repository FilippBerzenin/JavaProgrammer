package Lesson_2.Frame_1.frame_5.tank;

import java.util.Random;

public class Tank {

    private final int speed = 10;

    private int x;
    private int y;

    // 1 - up, 2- down, 3 - left, 4 - right
    private Direction direction;

//    private int TOP = 1;
//    private int BOTTOM = 2;
//    private int LEFT = 3;
//    private int RIGHT = 4;

    private int STEP = 1;

    private ActionField af;
    private BattelField bf;

    public Tank (ActionField af, BattelField bf) {
        this(af, bf, 128, 512, Direction.TOP);
    }

    public Tank (ActionField af, BattelField bf, int x, int y, Direction direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turn (Direction direction)throws Exception  {
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

//    public void moveRandom()throws Exception  {
//        Random r = new Random();
//        int i;
//        while (true) {
//            i = r.nextInt(5);
//            if (i > 0) {
//                turn(i);
//                move();
//            }
//        }
//    }

    public void tankDestroy () {
        x = -100;
        y = -100;
    }

    public void moveToQuadrant(int v, int h) throws Exception {
        af.processMoveToQuadrant(v,h);
    }


    public void clean() throws Exception {
        af.processClean();
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getTOP() {
        return direction.TOP;
    }

    public Direction getBOTTOM() {
        return direction.BOTTOM;
    }

    public Direction getLEFT() {
        return direction.LEFT;
    }

    public Direction getRIGHT() {
        return direction.RIGHT;
    }

//    public Direction getTOP() {
//        return Direction.TOP;
//    }
//
//    public Direction getBOTTOM() {
//        return Direction.BOTTOM;
//    }
//
//    public Direction getLEFT() {
//        return Direction.LEFT;
//    }
//
//    public Direction getRIGHT() {
//        return Direction.RIGHT;
//    }

    public int getSTEP() {
        return STEP;
    }

    public int getSpeed() {
        return speed;
    }
}
