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

        JLabel name1 = new JLabel("Your name");
        JTextField tf = new JTextField();
        panel.add(name1);
        panel.add(tf);

        JLabel lproduct = new JLabel("Cars:");

        ButtonGroup bg = new ButtonGroup();
        JPanel pp = new JPanel();
        for (int i = 0; i<stock.size(); i++) {
            JRadioButton pc = new JRadioButton(stock.get(i)[0].getName()+" "+stock.get(i)[0].getPrice());
            bg.add(pc);
            pp.add(pc);
        }

        panel.add(lproduct);
        panel.add(pp);

            JLabel count = new JLabel("Count");
            NumberFormat nf = NumberFormat.getNumberInstance();
            JFormattedTextField tfCount = new JFormattedTextField(nf);
            tfCount.setValue(0);
            panel.add(count);
            panel.add(tfCount);
//
//            JTextField tfAmount = new JTextField();
//            panel.add(tfAmount);


        JButton buttonBuy = new JButton("Buy");
        panel.add(buttonBuy);


        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
