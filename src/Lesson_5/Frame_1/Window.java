package Lesson_5.Frame_1;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

//    static int x = 50;

    public static void main (String[] args) throws Exception {
        Window w = new Window();

//        Thread.sleep(2000);
//        System.out.println("wake up");

//        x = 200;
        w.repaint();
    }

    public Window () {
        JFrame window = new JFrame();

        window.setLocation(300,100);
        window.setMinimumSize(new Dimension(600,400));

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.getContentPane().add(this);
        window.pack();

        window.setVisible(true);

//        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0,00,600,400);

        g.setColor(Color.BLUE);
        g.fillRect(150,150,50,50);
    }
}
