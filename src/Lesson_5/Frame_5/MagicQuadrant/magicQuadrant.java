package Lesson_5.Frame_5.MagicQuadrant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MagicQuadrant extends JPanel {

    private JTextField tf;
    private JFormattedTextField tfCount;
    Color c;
    JButton buttonBuy;
    int x;
    int y;
    int z;

    MagicQuadrant () {
        JFrame frame = new JFrame("Magic qudrant");
        frame.setMinimumSize(new Dimension(600,400));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(100,100);
        frame.pack();
        frame.getContentPane().add(quadrant());
    }

    private JPanel quadrant () {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        buttonBuy = new JButton();
        c = new Color(r(x),r(y),r(z));
        buttonBuy.setBackground(c);

        class RBListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.GREEN;
                buttonBuy.setBackground(new Color(r(x),r(y),r(z)));
            }
        }

        ActionListener rbListener = new RBListener();
        buttonBuy.addActionListener(rbListener);
        panel.add(buttonBuy, new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),50,70));
        return panel;
    }

    private int r (int r) {
        Random xr = new Random();
        r = xr.nextInt(255)+1;
       return r;
    }
}
