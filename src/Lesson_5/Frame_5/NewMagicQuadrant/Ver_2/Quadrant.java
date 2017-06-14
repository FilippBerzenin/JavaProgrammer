package Lesson_5.Frame_5.NewMagicQuadrant.Ver_2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Quadrant implements MouseListener {

    int xQadrant = 100;
    int yQadrant = 100;
    int widthQadrant = 100;
    int heightQadrant = 100;

    private Color c = Color.GREEN;

    Quadrant () {

    }


    public void draw (Graphics g) {
        g.setColor(c);
        g.fillRect(xQadrant,yQadrant,widthQadrant,heightQadrant);

    }

    private Color randomColor () {
        Random xr = new Random();
        int x = xr.nextInt(255)+1;
        int y = xr.nextInt(255)+1;
        int z = xr.nextInt(255)+1;
        c = new Color(x,y,z);
        return c;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX()<=(xQadrant+widthQadrant) && e.getX()>xQadrant &&
        e.getY()<=(yQadrant+heightQadrant) && e.getY()>yQadrant) {
        c = randomColor ();
        }
//        System.out.println("Ok Qadrant"+c);
//        System.out.println("mouseX "+e.getX()+" mouseY "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited");
    }
}
