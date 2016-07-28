package Lesson_3.Frame_3.Tank;

import java.util.Random;

public abstract class AbstractTank {

    protected int speed = 10;

    protected int x;
    protected int y;
    protected Bullet bullet;
    protected int armor = 0;

    // 1 - up, 2- down, 3 - left, 4 - right
    protected Direction direction;

//    protected int TOP = 1;
//    protected int BOTTOM = 2;
//    protected int LEFT = 3;
//    protected int RIGHT = 4;

    protected int STEP = 1;

    protected ActionField af;
    protected BattelField bf;

    public AbstractTank(ActionField af, BattelField bf) {
        this(af, bf, 64, 448, Direction.LEFT);
    }

    public AbstractTank(ActionField af, BattelField bf, int x, int y, Direction direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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

    public void fire (AbstractTank abstractTank) throws Exception {
        Bullet bullet = new Bullet(x+25, y+25, direction);
        af.processFire(bullet, abstractTank);
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

    protected Direction randonTurn (int i) {
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

    public void moveToQuadrant(int v, int h, AbstractTank abstractTank) throws Exception {
        af.processMoveToQuadrant(v,h, abstractTank);
    }


    public void clean(AbstractTank abstractTank) throws Exception {
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
