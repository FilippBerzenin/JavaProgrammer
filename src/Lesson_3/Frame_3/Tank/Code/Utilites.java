package Lesson_3.Frame_3.Tank.Code;

public class Utilites {

    public static String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    public static int getCoordinatesFromBattelFieldOfX (int j, int k) {
        String coordinates = getQuadrantXY(j + 1, k + 1);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        return x;
    }

    public static int getCoordinatesFromBattelFieldOfY (int j, int k) {
        String coordinates = getQuadrantXY(j + 1, k + 1);
        int separator = coordinates.indexOf("_");
        int y = Integer.parseInt(coordinates.substring(0, separator));
        int x = Integer.parseInt(coordinates.substring(separator + 1));
        return y;
    }
}
