package Lesson_2.Frame_1.frame_5.tank;

/**
 * Created by Samsung on 17.05.2016.
 */
public enum Direction {

    LEFT(3), RIGHT(4), TOP(1), BOTTOM(2);

    private static int id;

    private Direction (int id) {
    }

    public static int getId () {
        return id;
    }

//    private Direction randonTurn (int i) {
//        Direction turn;
//        switch (i) {
//            case 1:
//                turn =  Direction.TOP;
//                return turn;
//            break;
//            case 2:
//                turn =  Direction.BOTTOM;
//                return turn;
//            break;
//            case 3:
//                turn =  Direction.LEFT;
//                return turn;
//            break;
//            case 4:
//                turn =  Direction.RIGHT;
//                return turn;
//            break;
//            default:
//        }
//        return null;
//    }
}
