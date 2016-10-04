package Lesson_5.Frame_2;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.TRUETYPE_FONT;

public class WindowJ extends JPanel {
    static int x = 50;

    public static void main (String[] args) throws Exception {
        WindowJ w = new WindowJ();
//
//        Thread.sleep(2000);
//        System.out.println("wake up");

        x = 200;
        w.repaint();
    }

    public WindowJ () {
        JFrame window = new JFrame("My panel");

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

        g.setColor(Color.RED);
        g.setFont(new Font("TRUETYPE_FONT", Font.BOLD, 20));
        g.drawString("Just do it",200,100);
    }
}
