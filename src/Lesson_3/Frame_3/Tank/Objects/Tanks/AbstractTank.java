package Lesson_3.Frame_3.Tank.Objects.Tanks;

import Lesson_3.Frame_3.Tank.*;
import Lesson_3.Frame_3.Tank.Interface.Destroyable;
import Lesson_3.Frame_3.Tank.Interface.Drawable;
import Lesson_3.Frame_3.Tank.Objects.Bullet;
import Lesson_3.Frame_3.Tank.Objects.Enum.Direction;

import java.awt.*;
import java.util.Random;

public abstract class AbstractTank implements Drawable, Destroyable {

    protected int speed = 10;

    protected int x;
    protected int y;
    protected Bullet bullet;
    protected int armor = 0;
    protected Color tankColor;
    protected Color towerColor;

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

    @Override
    public void draw(Graphics g) {
// aggressor
        g.setColor(tankColor);
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(towerColor);
        if (this.getDirection() == Direction.TOP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.BOTTOM) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
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


    public void Destroy () {
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

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Color getTankColor() {
        return tankColor;
    }

    public void setTankColor(Color tankColor) {
        this.tankColor = tankColor;
    }

    public Color getTowerColor() {
        return towerColor;
    }

    public void setTowerColor(Color towerColor) {
        this.towerColor = towerColor;
    }

    public ActionField getAf() {
        return af;
    }

    public BattelField getBf() {
        return bf;
    }
}
