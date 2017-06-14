package Lesson_5.Frame_5.AngryFriends;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Circle implements MouseMotionListener, MouseListener {

    int xOval = 100;
    int yOval = 100;
    int widthOval = 100;
    int heightOval = 100;

    int frameX;
    int frameY;

    private Color c = Color.MAGENTA;

    Circle (int frameX, int frameY) {
        this.frameX = frameX;
        this.frameY = frameY;
    }

    public void draw (Graphics g) {
        g.setColor(c);
        g.fillOval(xOval,yOval,widthOval,heightOval);

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
//        System.out.println("mouseClicked" + "Circle");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed" + "Circle");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouseReleased" + "Circle");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered" + "Circle");
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited" + "Circle");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("mouseDragged" + "Circle");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getX()<=(xOval+widthOval) && e.getX()>xOval &&
                e.getY()<=(yOval+heightOval) && e.getY()>yOval) {
            if (e.getX()>=xOval && e.getX()<(xOval+widthOval/2)) {
                xOval=xOval+5;
            }
            else if (e.getX()<=xOval+widthOval && e.getX()>(xOval-widthOval/2)) {
                xOval=xOval-5;
            }
            if (e.getY()>=yOval && e.getY()<(yOval+heightOval/2)) {
                yOval=yOval+5;
            }
            else if (e.getY()<=yOval+heightOval && e.getY()>(yOval-heightOval/2)) {
                yOval=yOval-5;
            }
//                    System.out.println("mouseMoved" + "Circle");
            c = randomColor ();
        }
        if (xOval<-widthOval/2 || yOval<-heightOval/2 || xOval>frameX-widthOval/2 || yOval>frameY-heightOval/2) {
            System.out.println("new circle");
            xOval = frameX/2;
            yOval = frameY/2;
        }
    }
}
