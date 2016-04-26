package Lesson_1.frame_5.TankLauncher;

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

    }

    public void moveToQuadrant (int y, int x)throws Exception  {

    }

    public void clean ()throws Exception  {

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
