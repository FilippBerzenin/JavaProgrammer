package Lesson_5.Frame_1;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    public Window()  {
        JFrame f = new JFrame("My graphics 2D");
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(300, 100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(this);
        f.pack();
        f.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(203,30,0));
        g.fillRect(0, 0, 800, 600);

        g.setColor(new Color(86, 142, 204));
        g.fillRect(400, 100, 50, 50);

        g.setColor(new Color(34, 174, 93));
        g.draw3DRect(400, 200, 49, 49, true);

        g.setColor(new Color(255,255,255));
        g.setFont(new Font("BOLD",Font.PLAIN,32));
        g.drawString("Jast do it", 20, 50);

    }
    public static void main(String[] args)  {
        new Window();

    }


}
