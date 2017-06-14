package Lesson_5.Frame_5.NewMagicQuadrant.Ver_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Widow extends JPanel implements MouseListener {

    Quadrant q;

    Widow () {
        addMouseListener(this);
        q = new Quadrant();
        addMouseListener(q);
    }

    public void setFRame () {
        JFrame frame = new JFrame("Window");
        frame.setLocation(100,100);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JComponent newContentPane = new Widow();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        q.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
