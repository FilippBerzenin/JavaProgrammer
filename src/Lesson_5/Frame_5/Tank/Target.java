package Lesson_5.Frame_5.Tank;

import Lesson_5.Frame_5.Tank.enums.Direction;
import Lesson_5.Frame_5.Tank.tanks.BT7;

import java.util.ArrayList;

public class Target {



    ArrayList<position> way = new ArrayList<>();

    class position {
        Direction[] wayD;
        int y;
        int x;

        position (Direction[] wayD, int y, int x) {
            this.wayD = wayD;
            this.y = y;
            this.x = x;
        }

        public Direction[] getWayD() {
            return wayD;
        }
    }
}
