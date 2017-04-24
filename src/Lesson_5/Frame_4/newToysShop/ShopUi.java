package Lesson_5.Frame_4.newToysShop;

import Lesson_5.Frame_4.newToysShop.Objects.Toys;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;

public class ShopUi extends JPanel {

    private java.util.List<Toys[]> stock;

    ShopUi (BayToys bayToys) {
        stock = bayToys.getStock();
        JFrame f = new JFrame("Toys shop");
        f.setMinimumSize(new Dimension(800,600));
        f.setLocation(200,50);

        f.getContentPane().add(createSellimgPanel());

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
    }

    private JPanel createSellimgPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel name1 = new JLabel("Your name");
        JTextField tf = new JTextField();
        tf.setColumns(5);
        panel.add(name1, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0),0,0));
        panel.add(tf,    new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0),0,0));

        JLabel lproduct = new JLabel("Cars:");

        ButtonGroup bg = new ButtonGroup();
        JPanel pp = new JPanel();
        pp.setLayout(new GridLayout(stock.size(), 0));
        pp.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        for (int i = 0; i<stock.size(); i++) {
            JRadioButton pc = new JRadioButton(stock.get(i)[0].getName()+" "+stock.get(i)[0].getPrice());
            bg.add(pc);
            pp.add(pc);
        }

        panel.add(lproduct, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(3,0,0,0),0,0));
        panel.add(pp,       new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(3,0,0,0),0,0));

            JLabel count = new JLabel("Count");
            NumberFormat nf = NumberFormat.getNumberInstance();
            JFormattedTextField tfCount = new JFormattedTextField(nf);
            tfCount.setColumns(2);
            tfCount.setValue(0);
            panel.add(count, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(3,0,0,0),0,0));
            panel.add(tfCount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(3,0,0,0),0,0));
//
//            JTextField tfAmount = new JTextField();
//            panel.add(tfAmount);


        JButton buttonBuy = new JButton("Buy");
        panel.add(buttonBuy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(3,0,0,0),0,0));


        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
