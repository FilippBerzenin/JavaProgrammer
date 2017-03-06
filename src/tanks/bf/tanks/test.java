package tanks.bf.tanks;

public class test {

    private String[][] battleFieldTemplate = {
            {" ", "B", " ", "B", " ", " ", " ", "B", "T"},
            {" ", "B", " ", " ", " ", "B", " ", "B", " "},
            {" ", "B", "B", "B", "R", "B", "B", "B", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", " ", "R", "B", "E", "B", " ", "B", "B"},
            {"B", " ", "B", " ", " ", "B", " ", " ", "B"},
            {" ", " ", "B", "B", " ", "B", "B", " ", " "},
            {" ", "B", "B", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", "B", " ", "B", " ", " "}
    };

    public static void main (String[] agrs) {

        distanceForTank (3, 4, 3, 5);
    }



    private static boolean distanceForTank (int baseCoordinateY, int baseCoordinateX, int newCoordinateY, int newCoordinateX) {
        int tankX = 0;
        int tankY  = 8;

        int baseBisector = ((tankY-baseCoordinateY)*(tankY-baseCoordinateY))+((tankX-baseCoordinateX)*(tankX-baseCoordinateX));
        int newBisector = ((tankY-newCoordinateY)*(tankY-newCoordinateY))+((tankX-newCoordinateX)*(tankX-newCoordinateX));
        if (baseBisector>newBisector) {
            return true;
        }
        System.out.println("Base "+baseBisector+" New "+newBisector);
        return false;
    }
}
