package Lesson_3.Frame_3.Tank;

import java.awt.*;

public class T34 extends AbstractTank {

    public T34(ActionField af, BattelField bf) {
        super(af, bf);
    }

    public T34(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }

    @Override
    public void tankDestroy() {
        super.tankDestroy();
    }

    @Override
    public void draw() {
        af.repaint();
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        int i = 0;
//        Color cc;
//        for (int v = 0; v < 9; v++) {
//            for (int h = 0; h < 9; h++) {
//                if (COLORDED_MODE) {
//                    if (i % 2 == 0) {
//                        cc = new Color(252, 241, 177);
//                    } else {
//                        cc = new Color(233, 243, 255);
//                    }
//                } else {
//                    cc = new Color(180, 180, 180);
//                }
//                i++;
//                g.setColor(cc);
//                g.fillRect(h * 64, v * 64, 64, 64);
//            }
//        }
//
//        for (int j = 0; j < battelField.getDimentionY(); j++) {
//            for (int k = 0; k < battelField.getDimentionX(); k++) {
//                if (battelField.scanQuadrant(j,k).equals("B")) {
//                    String coordinates = getQuadrantXY(j + 1, k + 1);
//                    int separator = coordinates.indexOf("_");
//                    int y = Integer.parseInt(coordinates.substring(0, separator));
//                    int x = Integer.parseInt(coordinates.substring(separator + 1));
//                    g.setColor(new Color(0, 0, 255));
//                    g.fillRect(x, y, 64, 64);
//                }
//            }
//        }
//
//        // defender
//        g.setColor(new Color(0, 255, 0));
//        g.fillRect(T34.getX(), defender.getY(), 64, 64);
//
//        g.setColor(new Color(255, 0, 0));
//        if (defender.getDirection() == Direction.TOP) {
//            g.fillRect(defender.getX() + 20, defender.getY(), 24, 34);
//        } else if (defender.getDirection() == Direction.BOTTOM) {
//            g.fillRect(defender.getX() + 20, defender.getY() + 30, 24, 34);
//        } else if (defender.getDirection() == Direction.LEFT) {
//            g.fillRect(defender.getX(), defender.getY() + 20, 34, 24);
//        } else {
//            g.fillRect(defender.getX() + 30, defender.getY() + 20, 34, 24);
//        }
//
//        g.setColor(new Color(255, 255, 0));
//        g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
//    }
}
