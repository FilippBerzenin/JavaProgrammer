package tanks.bf;

import java.awt.*;

import static java.lang.Thread.*;

public class EndTheGame implements Drawable, Destroyable  {


    @Override
    public void destroy() {

    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    public void draw(Graphics g, int k) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            g.setColor(new Color(0, k, 0));
            g.setFont(new Font("Game over", Font.BOLD, 50));
            g.drawString("Game over", 180, 480 / 2);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            g.setColor(new Color(0, 0, 0));
//            g.setFont(new Font("Game over", Font.BOLD, 50));
//            g.drawString("Game over", 180, 480 / 2);
    }

    @Override
    public void draw(Graphics g) {

    }
}

