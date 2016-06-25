package Lesson_2.Frame_6.tank;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    final boolean COLORDED_MODE = false;

    private BattelField battelField;
//    private Tank tank;
    private int t;
//    private Tank agressor;
    private Bullet bullet;

    private Tank[] tank = new Tank[2];

    void runTheGame() throws Exception {
        tank[0].move();
//        tank[1].clean();
// //      tank.moveRandom();
//       tank.moveToQuadrant(5,5);
//       tank.fire();
//       tank.fire();
//       tank.fire();
//       tank.move();
//       tank.turn(Direction.LEFT);
//       tank.fire();
//       tank.move();
    }

    public void processTurn (Tank tank) throws Exception {
        repaint();
    }

    public void processMove (Tank tank) throws Exception {
        tank = tank;
        Direction direction = tank.getDirection();
        int step = tank.getSTEP();
        int covered = 0;
//        errorBorders(direction);
        // check limits x: 0, 513; y: 0, 513
        //       processTurn(direction);
        if ((direction == Direction.TOP && tank.getY() == 0) || (direction == Direction.BOTTOM && tank.getY() >= 512)
            || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() == 512)){
            System.out.print("Error of way");
            return;
        }

        tank.turn(direction);

        while (covered < 64) {
            if (direction == tank.getTOP()) {
//                scanTargetTop();
                tank.updateY(-tank.getSTEP());
            } else if (direction == tank.getBOTTOM()) {
//                scanTargetBottom();
                tank.updateY(+tank.getSTEP());
            } else if (direction == tank.getLEFT()) {
//                scanTargetLeft();
                tank.updateX(-tank.getSTEP());
            } else {
                //               scanTargetRight();
                tank.updateX(+tank.getSTEP());
            }
            covered += tank.getSTEP();
            repaint();
            Thread.sleep(tank.getSpeed());
        }
    }

    public void processMoveToQuadrant(int v, int h) throws Exception {
        String coordinates = getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        System.out.println("Driver! We have a route! Coordinates " + "Vertikal " + v + " "
                + "Horizontal " + h + " Go, go, go!");
        if (tank[t].getX() < x) {
            tank[t].turn(tank[t].getRIGHT());
            while (tank[t].getX() != x) {
                tank[t].move();
            }
        } else {
            tank[t].turn(tank[t].getLEFT());
            while (tank[t].getX() != x) {
                tank[t].move();
            }
        }
        if (tank[t].getY() < y) {
            tank[t].turn(tank[t].getBOTTOM());
            while (tank[t].getY() != y) {
                tank[t].move();
            }
        } else {
            tank[t].turn(tank[t].getTOP());
            while (tank[t].getY() != y) {
                tank[t].move();
            }
        }
    }


    public void processClean ()throws Exception  {
        for (int i = 1; i < battelField.battleField.length + 1; i++) {
            tank[t].moveToQuadrant(i, 1);
//            af.scanTargetTop();
//            af.scanTargetLeft();
//            af.scanTargetBottom();
            scanTargetRight();
        }
    }

    public void processFire (Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while (bullet.getX() > -bullet.getBULLET_SIZE() && bullet.getX() < (bullet.getBULLET_SIZE() + battelField.getBF_WIDTH())
                && bullet.getY() > -bullet.getBULLET_SIZE() && bullet.getY() < (bullet.getBULLET_SIZE() + battelField.getBF_HEIGHT())) {
            if (bullet.getDirction() == tank[t].getTOP()) {
                bullet.updateY(-step);
            } else if (bullet.getDirction() == tank[t].getBOTTOM()) {
                bullet.updateY(+step);
            } else if (bullet.getDirction() == tank[t].getLEFT()) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(+step);
            }
            if (processInterception()) {
                bullet.destroy();
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }

    void scanTargetTop() throws Exception {
        int indexHorizontal = getCoordinatesX();
        tank[t].turn(tank[t].getTOP());
        for (int i = tank[t].getY(); i > -(battelField.getBF_HEIGHT()/battelField.getDimentionY()); i -= (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank[t].fire();
            }
        }
    }

    void scanTargetBottom() throws Exception {
        int indexHorizontal = getCoordinatesX();
        tank[t].turn(tank[t].getBOTTOM());
        for (int i = tank[t].getY(); i < battelField.getBF_HEIGHT(); i += (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank[t].fire();
            }
        }
    }

    void scanTargetLeft(int t) throws Exception {
        int indexVertikal = getCoordinatesY();
        tank[t].turn(tank[t].getRIGHT());
        for (int i = tank[t].getX(); i < battelField.getBF_WIDTH(); i -= (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank[t].fire();
            }
        }
    }

    void scanTargetRight() throws Exception {
        int indexVertikal = getCoordinatesY();
        tank[t].turn(tank[t].getRIGHT());
        for (int i = tank[t].getX(); i < battelField.getBF_WIDTH(); i += (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank[t].fire();
            }
        }
    }

    int getCoordinatesX() {
        int CoordinatesX = tank[t].getX() / (battelField.getBF_WIDTH()/battelField.getDimentionX());
        return CoordinatesX;
    }

    int getCoordinatesY() {
        int CoordinatesY = tank[t].getY() / (battelField.getBF_HEIGHT()/battelField.getDimentionY());
        return CoordinatesY;
    }


//    int bulletBorder(int direction) {
//        int bulletBorder = 0;
//        if (direction == tank.getTOP()) {
//            bulletBorder = tank.getY() + bullet.getBULLET_IPHEAVAL() + bullet.getBULLET_SIZE();
//        } else if (direction == tank.getBOTTOM()) {
//            bulletBorder = battelField.getBF_HEIGHT() - tank.getY() - bullet.getBULLET_IPHEAVAL() + bullet.getBULLET_SIZE();
//        } else if (direction == tank.getLEFT()) {
//            bulletBorder = tank.getX() + bullet.getBULLET_IPHEAVAL() + bullet.getBULLET_SIZE();
//        } else if (direction == tank.getRIGHT()) {
//            bulletBorder = battelField.getBF_WIDTH() - tank.getX() - bullet.getBULLET_IPHEAVAL() + bullet.getBULLET_SIZE();
//        }
//        return bulletBorder;
//    }

    private boolean processInterception() {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);

        if(y >= 0 && y < 9 && x >=0 && x < 9) {
            if (!battelField.scanQuadrant(y, x).trim().isEmpty()) {
                battelField.updateQuadrant(y, x, "");
                return true;
            }
        }
        return false;
    }

    public String getQuadrant(int x, int y) {
        return y/64 + "_" +x/64;
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public ActionField() throws Exception {
        battelField = new BattelField();

        tank[0] = new Tank();
        tank[0].setAf(this);
        tank[0].setBf(battelField);
        tank[0].setX(256);
        tank[0].setY(256);
        tank[0].setDirection(Direction.TOP);

        tank[1] = new BT7();
        tank[1].setAf(this);
        tank[1].setBf(battelField);
        tank[1].setX(512);
        tank[1].setY(512);
        tank[1].setDirection(Direction.BOTTOM);

        bullet = new Bullet(-100, -100, Direction.TOP);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(battelField.getBF_WIDTH()+16, battelField.getBF_HEIGHT()+38));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
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

        for (int j = 0; j < battelField.getDimentionY(); j++) {
            for (int k = 0; k < battelField.getDimentionX(); k++) {
                if (battelField.scanQuadrant(j,k).equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tank[t].getX(), tank[t].getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (tank[t].getDirection() == Direction.TOP) {
            g.fillRect(tank[t].getX() + 20, tank[t].getY(), 24, 34);
        } else if (tank[t].getDirection() == Direction.BOTTOM) {
            g.fillRect(tank[t].getX() + 20, tank[t].getY() + 30, 24, 34);
        } else if (tank[t].getDirection() == Direction.LEFT) {
            g.fillRect(tank[t].getX(), tank[t].getY() + 20, 34, 24);
        } else {
            g.fillRect(tank[t].getX() + 30, tank[t].getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }

    public void setT(int t) {
        this.t = t;
    }
}
