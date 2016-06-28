package Lesson_2.Frame_6.tank;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.Arrays;

public class ActionField extends JPanel {

    final boolean COLORDED_MODE = false;

    private BattelField battelField;
//    private Tank tank;
    private Tank defender;
    private BT7 agressor;
    private Bullet bullet;
    private Tank [] tanks = new Tank[2];

    void runTheGame() throws Exception {
//        agressor.clean(agressor);
        defender.clean(defender);
        defender.fire(defender);
        defender.fire(defender);
        defender.fire(defender);
    }

    public void processTurn (Tank tank) throws Exception {
        repaint();
    }

    public void processMove (Tank tank) throws Exception {
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

    public void processMoveToQuadrant(int v, int h, Tank tank) throws Exception {
        String coordinates = getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        System.out.println("Driver! We have a route! Coordinates " + "Vertikal " + v + " "
                + "Horizontal " + h + " Go, go, go!");
        if (tank.getX() < x) {
            tank.turn(tank.getRIGHT());
            while (tank.getX() != x) {
                tank.move();
            }
        } else {
            tank.turn(tank.getLEFT());
            while (tank.getX() != x) {
                tank.move();
            }
        }
        if (tank.getY() < y) {
            tank.turn(tank.getBOTTOM());
            while (tank.getY() != y) {
                tank.move();
            }
        } else {
            tank.turn(tank.getTOP());
            while (tank.getY() != y) {
                tank.move();
            }
        }
    }


    public void processClean (Tank tank)throws Exception  {
        for (int i = 1; i < battelField.battleField.length + 1; i++) {
            tank.moveToQuadrant(i, 1, tank);
//            af.scanTargetTop();
//            af.scanTargetLeft();
//            af.scanTargetBottom();
            scanTargetRight(tank);
        }
    }

    public void processFire (Bullet bullet, Tank tank) throws Exception {
//        System.out.println(Arrays.toString(tanks));
        setArrayTanks(tank);
//        System.out.println(Arrays.toString(tanks));
        this.bullet = bullet;
        int step = 1;
        while (bullet.getX() > -bullet.getBULLET_SIZE() && bullet.getX() < (bullet.getBULLET_SIZE() + battelField.getBF_WIDTH())
                && bullet.getY() > -bullet.getBULLET_SIZE() && bullet.getY() < (bullet.getBULLET_SIZE() + battelField.getBF_HEIGHT())) {
            if (bullet.getDirction() == tank.getTOP()) {
                bullet.updateY(-step);
            } else if (bullet.getDirction() == tank.getBOTTOM()) {
                bullet.updateY(+step);
            } else if (bullet.getDirction() == tank.getLEFT()) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(+step);
            }
//            System.out.println("Bullet Y: "+bullet.getY()+" X: "+bullet.getX()+"Tank position: Y:"+tanks[1].getY()+" X:"+tanks[1].getX());
            if (processInterception()) {
                bullet.destroy();
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }

    private void setArrayTanks (Tank tank) {
        int i;
        for (i = 0; i < tanks.length; i++) {
            if (tank.toString().equals(tanks[i].toString())) {

                Tank mem = tanks[0];
                tanks[0] = tank;
                tanks[i] = mem;
            }
        }
    }

    void scanTargetTop(Tank tank) throws Exception {
        int indexHorizontal = getCoordinatesX(tank);
        tank.turn(tank.getTOP());
        for (int i = tank.getY(); i > -(battelField.getBF_HEIGHT()/battelField.getDimentionY()); i -= (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank.fire(tank);
            }
        }
    }

    void scanTargetBottom(Tank tank) throws Exception {
        int indexHorizontal = getCoordinatesX(tank);
        tank.turn(tank.getBOTTOM());
        for (int i = tank.getY(); i < battelField.getBF_HEIGHT(); i += (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank.fire(tank);
            }
        }
    }

    void scanTargetLeft(Tank tank) throws Exception {
        int indexVertikal = getCoordinatesY(tank);
        tank.turn(tank.getRIGHT());
        for (int i = tank.getX(); i < battelField.getBF_WIDTH(); i -= (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank.fire(tank);
            }
        }
    }

    void scanTargetRight(Tank tank) throws Exception {
        int indexVertikal = getCoordinatesY(tank);
        tank.turn(tank.getRIGHT());
        for (int i = tank.getX(); i < battelField.getBF_WIDTH(); i += (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                tank.fire(tank);
            }
        }
    }

    int getCoordinatesX(Tank tank) {
        int CoordinatesX = tank.getX() / (battelField.getBF_WIDTH()/battelField.getDimentionX());
        return CoordinatesX;
    }

    int getCoordinatesY(Tank tank) {
        int CoordinatesY = tank.getY() / (battelField.getBF_HEIGHT()/battelField.getDimentionY());
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

    private boolean processInterceptionBricks (int y, int x) throws Exception {
        if(y >= 0 && y < 9 && x >=0 && x < 9) {
            if (battelField.scanQuadrant(y, x).equals("B")) {
                battelField.updateQuadrant(y, x, "");
//                System.out.println(tanks[0].toString());
                return true;
            }
        }
        return false;
    }

    private boolean processInterceptionTank () {
        if (bullet.getDirction() == Direction.TOP) {
            if ((agressor.getY()+64) == bullet.getY() && agressor.getX() == bullet.getX() - 25) {
                System.out.print("Bingo!");
//                tankRecovery();
                return true;
            }
        }
         else if (bullet.getDirction() == Direction.BOTTOM) {
            if (agressor.getY() == bullet.getY() && agressor.getX() == bullet.getX() - 25) {
                System.out.print("Bingo!");
//                tankRecovery();
                return true;
            }
        }
        else if (bullet.getDirction() == Direction.LEFT) {
            if (agressor.getX()+64 == bullet.getX() && agressor.getY() == bullet.getY() - 25) {
                System.out.print("Bingo!");
//                tankRecovery();
                return true;
            }
        }
        else if (bullet.getDirction() == Direction.RIGHT) {
            if (agressor.getX() == bullet.getX() && agressor.getY() == bullet.getY() - 25) {
                System.out.print("Bingo!");
//                tankRecovery();
                return true;
            }
        }
        return false;
    }

    private boolean processInterception() throws Exception {
        String coordinates = getQuadrant(bullet.getX(), bullet.getY());
        int y = Integer.parseInt(coordinates.split("_")[0]);
        int x = Integer.parseInt(coordinates.split("_")[1]);

        if (processInterceptionBricks (y, x) == true) {
            return true;
        }
        else if (processInterceptionTank() == true) {
            agressor.tankDestroy();
            bullet.destroy();
            repaint();
            Thread.sleep(1700);
            tankRecovery();
        }
        return false;
    }

    public void tankRecovery () throws Exception  {
        String location = battelField.getAgressorLocation();
        int x = Integer.parseInt(location.split("_")[1]);
        int y = Integer.parseInt(location.split("_")[0]);
        agressor = new BT7(this, battelField, x, y, Direction.LEFT);
        System.out.println("I am a live!");
        tanks[1] = agressor;
        repaint();
//        Thread.sleep(1700);
//        repaint();
    }

    public String getQuadrant(int x, int y) {
        return y/64 + "_" +x/64;
    }

    public String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public ActionField() throws Exception {
        battelField = new BattelField();

        defender = new Tank(this, battelField, 448, 64, Direction.LEFT);
        tanks[0] = defender;

        String location = battelField.getAgressorLocation();
        agressor = new BT7(this, battelField, Integer.parseInt(location.split("_")[1]),
                Integer.parseInt(location.split("_")[0]), Direction.LEFT);
        tanks[1] = agressor;
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

        // defender
        g.setColor(new Color(0, 255, 0));
        g.fillRect(defender.getX(), defender.getY(), 64, 64);

        g.setColor(new Color(255, 0, 0));
        if (defender.getDirection() == Direction.TOP) {
            g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
        } else if (defender.getDirection() == Direction.BOTTOM) {
            g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
        } else if (defender.getDirection() == Direction.LEFT) {
            g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
        } else {
            g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
        }

        // aggressor
        g.setColor(new Color(255, 0, 0));
        g.fillRect(agressor.getX(), agressor.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (agressor.getDirection() == Direction.TOP) {
            g.fillRect(agressor.getX() + 20, agressor.getY(), 24, 34);
        } else if (agressor.getDirection() == Direction.BOTTOM) {
            g.fillRect(agressor.getX() + 20, agressor.getY() + 30, 24, 34);
        } else if (agressor.getDirection() == Direction.LEFT) {
            g.fillRect(agressor.getX(), agressor.getY() + 20, 34, 24);
        } else {
            g.fillRect(agressor.getX() + 30, agressor.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
    }
}
