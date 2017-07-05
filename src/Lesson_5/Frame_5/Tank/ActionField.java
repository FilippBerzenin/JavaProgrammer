package Lesson_5.Frame_5.Tank;

import Lesson_5.Frame_5.Tank.bf.Blank;
import Lesson_5.Frame_5.Tank.bf.Eagle;
import Lesson_5.Frame_5.Tank.enums.Action;
import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.interfaces.BFObject;
import Lesson_5.Frame_5.Tank.interfaces.Tank;
import Lesson_5.Frame_5.Tank.tanks.BT7;
import Lesson_5.Frame_5.Tank.tanks.Bullet;
import Lesson_5.Frame_5.Tank.tanks.T34;
import Lesson_5.Frame_5.Tank.tanks.Tiger;
import Lesson_5.Frame_5.Tank.bf.Water;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Updated to object oriented style.
 *
 * @version 3.0
 */
public class ActionField extends JPanel {

    private boolean COLORDED_MODE = false;

    private BattleField battleField;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;
    private boolean run = true;

    /**
     * Write your code here.
     */


    void runTheGame() throws Exception {
        aggressor.findEnemy(defender.getX(), defender.getY());
//        aggressor.findEnemy(defender.getX(), defender.getY());
//        System.out.println(Arrays.toString(aggressor.getEnemyCoordinates()));
        while (run) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                aggressor.setEnemy(defender.getX(), defender.getY());
                processAction(aggressor.setUp(), aggressor);
            }
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                defender.setEnemy(aggressor.getX(), aggressor.getY());
                processAction(defender.setUp(), defender);
            }
        }
    }

    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
    }


    private void processTurn(Tank tank) throws Exception {
        repaint();
    }

    int q=0;

    private void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 1;

        for (int i = 0; i < tank.getMovePath(); i++) {
            int covered = 0;

            String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
            int v = Integer.parseInt(tankQuadrant.split("_")[0]);
            int h = Integer.parseInt(tankQuadrant.split("_")[1]);

            // check limits x: 0, 513; y: 0, 513
            if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
                    || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }

            // check next quadrant before move
            if (direction == Direction.UP) {
                v--;
            } else if (direction == Direction.DOWN) {
                v++;
            } else if (direction == Direction.RIGHT) {
                h++;
            } else if (direction == Direction.LEFT) {
                h--;
            }
            BFObject bfobject = battleField.scanQuadrant(v, h);
            if (!(bfobject instanceof Blank || bfobject instanceof Water) && !bfobject.isDestroyed()) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY()+bfobject+v+""+h);
                return;
            }


            // process move

            while (covered < 64) {
                if (direction == Direction.UP) {
                    tank.updateY(-step);
                    //				System.out.println("[move up] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.DOWN) {
                    tank.updateY(step);
                    //				System.out.println("[move down] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.LEFT) {
                    tank.updateX(-step);
                    //				System.out.println("[move left] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                } else if (direction == Direction.RIGHT) {
                    tank.updateX(step);
                    //				System.out.println("[move right] direction: " + direction + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                }
                covered += step;

                repaint();
                Thread.sleep(tank.getSpeed());
            }
        }
    }

    private void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while ((bullet.getX() > -14 && bullet.getX() < 590)
                && (bullet.getY() > -14 && bullet.getY() < 590)) {
            if (bullet.getDirection() == Direction.UP) {
                bullet.updateY(-step);
            } else if (bullet.getDirection() == Direction.DOWN) {
                bullet.updateY(step);
            } else if (bullet.getDirection() == Direction.LEFT) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(step);
            }
            if (processInterception()) {
                bullet.destroy();
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
            if (bullet.isDestroyed()) {
                break;
            }
        }
    }

    private boolean processInterception() {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            BFObject bfObject = battleField.scanQuadrant(y, x);
            if (bfObject instanceof Water) {
                return false;
            }
            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank) ) {
//                System.out.println(bfObject);
//                if (bfObject instanceof Water) {
//                    System.out.println("water");
//                    return false;
//                }
                if (bfObject instanceof Eagle) {
                    battleField.destroyObject(y, x);
                    run = false;
                    return true;
                }
                battleField.destroyObject(y, x);
                return true;
            }

            // check aggressor
            if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(), aggressor.getY()), coordinates)) {
                aggressor.destroy();
                return true;
            }

            // check aggressor
            if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(), defender.getY()), coordinates)) {
                defender.destroy();
                return true;
            }
        }
        return false;
    }

    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        // input data should be correct
        return y / 64 + "_" + x / 64;
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        defender = new T34(battleField);

        String location = battleField.getAggressorLocation();
        aggressor = new Tiger(battleField,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.UP);

        bullet = new Bullet(-1000, -1000, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 7");
        frame.setLocation(650, 50);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth()+16, battleField.getBfHeight() + 38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g)  {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

        battleField.draw(g);
        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }
}