package Lesson_5.Frame_5.AngryFriends;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Widow extends JPanel implements MouseListener, MouseMotionListener {

//    Quadrant q;
    Circle c1;

    int frameX = 600;
    int frameY = 400;

    Widow () {
        addMouseListener(this);
        addMouseMotionListener(this);
        c1 = new Circle(frameX, frameY);
        addMouseListener(c1);
        addMouseMotionListener(c1);
    }

    public void setFRame () {
        JFrame frame = new JFrame("Window");
        frame.setLocation(100,100);
        frame.setMinimumSize(new Dimension(frameX,frameY));
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JComponent newContentPane = new Widow();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        c1.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("mousePressed");
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

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println("mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("mouseMoved");
//        if(true) {
//            System.out.println(e.getX());
//        }
        repaint();
    }


}
