package Lesson_2.Frame_6.tank;

import java.util.Random;

public class Tank {

    protected int speed = 5;

    private int x;
    private int y;
    private Bullet bullet;

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
        this(af, bf, 64, 448, Direction.LEFT);
    }

    public Tank (ActionField af, BattelField bf, int x, int y, Direction direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void turn (Direction direction)throws Exception  {
        this.direction = direction;
        af.processTurn(this);
    }

    public void move () throws Exception {
//        System.out.print(toString());
        af.processMove(this);
    }

    public void fire (Tank tank) throws Exception {
        Bullet bullet = new Bullet(x+25, y+25, direction);
        af.processFire(bullet, tank);
    }

    public void moveRandom()throws Exception  {
        Random r = new Random();
        int i;
        while (true) {
            i = r.nextInt(5);
            if (i > 0) {
                turn(randonTurn(i));
                move();
            }
        }
    }

    private Direction randonTurn (int i) {
            Direction turnR = null;
        switch (i) {
            case 1:
                turnR =  Direction.TOP;
//                return turnR;
            break;
            case 2:
                turnR =  Direction.BOTTOM;
 //               return turnR;
            break;
            case 3:
                turnR =  Direction.LEFT;
 //               return turnR;
            break;
            case 4:
                turnR =  Direction.RIGHT;
   //             return turnR;
                break;
                default:
            }
        return turnR;
    }


    public void tankDestroy () {
        x = -100;
        y = -100;
    }

    public void moveToQuadrant(int v, int h, Tank tank) throws Exception {
        af.processMoveToQuadrant(v,h, tank);
    }


    public void clean(Tank tank) throws Exception {
        af.processClean(this);
    }

    @Override
    public String toString() {
        return "Main tank ";
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSTEP(int STEP) {
        this.STEP = STEP;
    }

    public void setAf(ActionField af) {
        this.af = af;
    }

    public void setBf(BattelField bf) {
        this.bf = bf;
    }
}
