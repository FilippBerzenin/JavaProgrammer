package Lesson_5.Frame_1;

import javax.swing.*;
import java.awt.*;

public class Window {

    public static void main (String[] args) {
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setLocation(300,100);
        window.setMinimumSize(new Dimension(800,600));
    }

}
