package Lesson_3.Frame_3.Tank;

import java.awt.*;

public class Tiger extends AbstractTank {

    public Tiger(ActionField af, BattelField bf) {
        super(af, bf);
        armor = 1;
    }

    public Tiger(ActionField af, BattelField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }

    @Override
    public void tankDestroy() {
        super.tankDestroy();
    }

    @Override
    public void draw(Graphics g) {
// aggressor
        g.setColor(new Color(255, 0, 0));
        g.fillRect(this.getX(), this.getY(), 64, 64);

        g.setColor(new Color(0, 255, 0));
        if (this.getDirection() == Direction.TOP) {
            g.fillRect(this.getX() + 20, this.getY(), 24, 34);
        } else if (this.getDirection() == Direction.BOTTOM) {
            g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
        } else if (this.getDirection() == Direction.LEFT) {
            g.fillRect(this.getX(), this.getY() + 20, 34, 24);
        } else {
            g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
        }
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
