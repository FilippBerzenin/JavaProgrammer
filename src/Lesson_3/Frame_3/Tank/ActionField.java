package Lesson_3.Frame_3.Tank;

import javax.swing.*;
import java.awt.*;

public class ActionField extends JPanel {

    final boolean COLORDED_MODE = false;

    private BattelField battelField;
//    private AbstractTank tank;
    private T34 defender;
//    private BT7 agressor;
    private Tiger agressor;
    private Bullet bullet;
    private AbstractTank[] abstractTanks = new AbstractTank[2];

    void runTheGame() throws Exception {
//        agressor.clean(agressor);
//        defender.clean(defender);
//        agressor.fire(agressor);
        defender.fire(defender);
        defender.fire(defender);
        defender.fire(defender);
    }

    public void processTurn (AbstractTank abstractTank) throws Exception {
        repaint();
    }

    public void processMove (AbstractTank abstractTank) throws Exception {
        Direction direction = abstractTank.getDirection();
        int step = abstractTank.getSTEP();
        int covered = 0;
//        errorBorders(direction);
        // check limits x: 0, 513; y: 0, 513
        //       processTurn(direction);
        if ((direction == Direction.TOP && abstractTank.getY() == 0) || (direction == Direction.BOTTOM && abstractTank.getY() >= 512)
            || (direction == Direction.LEFT && abstractTank.getX() == 0) || (direction == Direction.RIGHT && abstractTank.getX() == 512)){
            System.out.print("Error of way");
            return;
        }

        abstractTank.turn(direction);

        while (covered < 64) {
            if (direction == abstractTank.getTOP()) {
//                scanTargetTop();
                abstractTank.updateY(-abstractTank.getSTEP());
            } else if (direction == abstractTank.getBOTTOM()) {
//                scanTargetBottom();
                abstractTank.updateY(+abstractTank.getSTEP());
            } else if (direction == abstractTank.getLEFT()) {
//                scanTargetLeft();
                abstractTank.updateX(-abstractTank.getSTEP());
            } else {
                //               scanTargetRight();
                abstractTank.updateX(+abstractTank.getSTEP());
            }
            covered += abstractTank.getSTEP();
            repaint();
            Thread.sleep(abstractTank.getSpeed());
        }
    }

    public void processMoveToQuadrant(int v, int h, AbstractTank abstractTank) throws Exception {
        String coordinates = getQuadrantXY(v, h);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        System.out.println("Driver! We have a route! Coordinates " + "Vertikal " + v + " "
                + "Horizontal " + h + " Go, go, go!");
        if (abstractTank.getX() < x) {
            abstractTank.turn(abstractTank.getRIGHT());
            while (abstractTank.getX() != x) {
                abstractTank.move();
            }
        } else {
            abstractTank.turn(abstractTank.getLEFT());
            while (abstractTank.getX() != x) {
                abstractTank.move();
            }
        }
        if (abstractTank.getY() < y) {
            abstractTank.turn(abstractTank.getBOTTOM());
            while (abstractTank.getY() != y) {
                abstractTank.move();
            }
        } else {
            abstractTank.turn(abstractTank.getTOP());
            while (abstractTank.getY() != y) {
                abstractTank.move();
            }
        }
    }


    public void processClean (AbstractTank abstractTank)throws Exception  {
        for (int i = 1; i < battelField.battleField.length + 1; i++) {
            abstractTank.moveToQuadrant(i, 1, abstractTank);
//            af.scanTargetTop();
//            af.scanTargetLeft();
//            af.scanTargetBottom();
            scanTargetRight(abstractTank);
        }
    }

    public void processFire (Bullet bullet, AbstractTank abstractTank) throws Exception {
//        System.out.println(Arrays.toString(abstractTanks));
        setArrayTanks(abstractTank);
//        System.out.println(Arrays.toString(abstractTanks));
        this.bullet = bullet;
        int step = 1;
        while (bullet.getX() > -bullet.getBULLET_SIZE() && bullet.getX() < (bullet.getBULLET_SIZE() + battelField.getBF_WIDTH())
                && bullet.getY() > -bullet.getBULLET_SIZE() && bullet.getY() < (bullet.getBULLET_SIZE() + battelField.getBF_HEIGHT())) {
            if (bullet.getDirction() == abstractTank.getTOP()) {
                bullet.updateY(-step);
            } else if (bullet.getDirction() == abstractTank.getBOTTOM()) {
                bullet.updateY(+step);
            } else if (bullet.getDirction() == abstractTank.getLEFT()) {
                bullet.updateX(-step);
            } else {
                bullet.updateX(+step);
            }
//            System.out.println("Bullet Y: "+bullet.getY()+" X: "+bullet.getX()+"AbstractTank position: Y:"+abstractTanks[1].getY()+" X:"+abstractTanks[1].getX());
            if (processInterception()) {
                bullet.destroy();
            }
            repaint();
            Thread.sleep(bullet.getSpeed());
        }
    }

    private void setArrayTanks (AbstractTank abstractTank) {
        int i;
        for (i = 0; i < abstractTanks.length; i++) {
            if (abstractTank.toString().equals(abstractTanks[i].toString())) {

                AbstractTank mem = abstractTanks[0];
                abstractTanks[0] = abstractTank;
                abstractTanks[i] = mem;
            }
        }
    }

    void scanTargetTop(AbstractTank abstractTank) throws Exception {
        int indexHorizontal = getCoordinatesX(abstractTank);
        abstractTank.turn(abstractTank.getTOP());
        for (int i = abstractTank.getY(); i > -(battelField.getBF_HEIGHT()/battelField.getDimentionY()); i -= (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                abstractTank.fire(abstractTank);
            }
        }
    }

    void scanTargetBottom(AbstractTank abstractTank) throws Exception {
        int indexHorizontal = getCoordinatesX(abstractTank);
        abstractTank.turn(abstractTank.getBOTTOM());
        for (int i = abstractTank.getY(); i < battelField.getBF_HEIGHT(); i += (battelField.getBF_HEIGHT()/battelField.getDimentionY())) {
            int indexVertikal = (i / (battelField.getBF_HEIGHT()/battelField.getDimentionY()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                abstractTank.fire(abstractTank);
            }
        }
    }

    void scanTargetLeft(AbstractTank abstractTank) throws Exception {
        int indexVertikal = getCoordinatesY(abstractTank);
        abstractTank.turn(abstractTank.getRIGHT());
        for (int i = abstractTank.getX(); i < battelField.getBF_WIDTH(); i -= (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                abstractTank.fire(abstractTank);
            }
        }
    }

    void scanTargetRight(AbstractTank abstractTank) throws Exception {
        int indexVertikal = getCoordinatesY(abstractTank);
        abstractTank.turn(abstractTank.getRIGHT());
        for (int i = abstractTank.getX(); i < battelField.getBF_WIDTH(); i += (battelField.getBF_WIDTH()/battelField.getDimentionX())) {
            int indexHorizontal = (i / (battelField.getBF_WIDTH()/battelField.getDimentionX()));
            if (battelField.scanQuadrant(indexVertikal, indexHorizontal).equals("B")) {
                System.out.println("We have target!");
                abstractTank.fire(abstractTank);
            }
        }
    }

    int getCoordinatesX(AbstractTank abstractTank) {
        int CoordinatesX = abstractTank.getX() / (battelField.getBF_WIDTH()/battelField.getDimentionX());
        return CoordinatesX;
    }

    int getCoordinatesY(AbstractTank abstractTank) {
        int CoordinatesY = abstractTank.getY() / (battelField.getBF_HEIGHT()/battelField.getDimentionY());
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
//                System.out.println(abstractTanks[0].toString());
                return true;
            }
        }
        return false;
    }

    private boolean processInterceptionTank () {
        if (bullet.getDirction() == Direction.TOP) {
            if ((abstractTanks[1].getY()+64) == bullet.getY() && abstractTanks[1].getX() == bullet.getX() - 25) {
                System.out.print("Bingo!");
//                if (abstractTanks[1].getArmor()>0) {
//                    abstractTanks[1].setArmor(abstractTanks[1].getArmor()-1);
//                }
//                tankRecovery();
                return true;
            }
        }
         else if (bullet.getDirction() == Direction.BOTTOM) {
            if (abstractTanks[1].getY() == bullet.getY() && abstractTanks[1].getX() == bullet.getX() - 25) {
                System.out.print("Bingo!");
//                if (abstractTanks[1].getArmor()>0) {
//                    abstractTanks[1].setArmor(abstractTanks[1].getArmor()-1);
//                }
//                tankRecovery();
                return true;
            }
        }
        else if (bullet.getDirction() == Direction.LEFT) {
            if (abstractTanks[1].getX()+64 == bullet.getX() && abstractTanks[1].getY() == bullet.getY() - 25) {
                System.out.print("Bingo!");
//                if (abstractTanks[1].getArmor()>0) {
//                    abstractTanks[1].setArmor(abstractTanks[1].getArmor()-1);
//                }
//                tankRecovery();
                return true;
            }
        }
        else if (bullet.getDirction() == Direction.RIGHT) {
            if (abstractTanks[1].getX() == bullet.getX() && abstractTanks[1].getY() == bullet.getY() - 25) {
                System.out.print("Bingo!");
//                if (abstractTanks[1].getArmor()>0) {
//
//                    abstractTanks[1].setArmor(abstractTanks[1].getArmor()-1);
//                }
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
            if (abstractTanks[1].getArmor() > 0) {
                System.out.println("Upss...");
                    bullet.destroy();
                    abstractTanks[1].setArmor(abstractTanks[1].getArmor()-1);

            } else {
                abstractTanks[1].tankDestroy();
                bullet.destroy();
                repaint();
                Thread.sleep(1700);
                if (abstractTanks[1].toString().equals("Main tank ")) {
                    System.out.println("GAME OVER");
//                System.exit(0);
                } else tankRecovery();
            }
        }
        return false;
    }

    public void tankRecovery () throws Exception  {
        String location = battelField.getAgressorLocation();
        int x = Integer.parseInt(location.split("_")[1]);
        int y = Integer.parseInt(location.split("_")[0]);
        agressor = new Tiger(this, battelField, x, y, Direction.LEFT);
        System.out.println("I am a live!");
        abstractTanks[1] = agressor;
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

        defender = new T34(this, battelField, 448, 64, Direction.LEFT);
        abstractTanks[0] = defender;

        String location = battelField.getAgressorLocation();
        agressor = new Tiger(this, battelField, Integer.parseInt(location.split("_")[1]),
                Integer.parseInt(location.split("_")[0]), Direction.RIGHT);
        abstractTanks[1] = agressor;
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
