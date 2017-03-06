package Lesson_5.Frame_1.New;

import javax.swing.*;

public class Frame {

    public static void main (String [] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(300, 100);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
