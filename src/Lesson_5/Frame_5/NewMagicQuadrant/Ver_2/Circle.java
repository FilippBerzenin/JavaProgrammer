package Lesson_5.Frame_5.NewMagicQuadrant.Ver_2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Circle implements MouseMotionListener {

    Circle () {

    }

    public void draw (Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillOval(100,100,50,50);

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
