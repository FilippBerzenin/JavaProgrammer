package Lesson_2.Frame_6.tank;

import java.util.Random;

public class BattelField {
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", "B", " ", " ", "B", " ", " ", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    public BattelField () {

    }

    public String getAgressorLocation () {
        String rez;
        Random random = new Random();
        int i;
        i = random.nextInt(3);
        if (i == 0) {
            rez = "64_64";
        } else {
            if (i == 1) {
                rez = "192_256";
            }
            else {
                rez = "64_448";
            }
        }
//        System.out.print(rez);
        return rez;
    }

    public BattelField (String [][] BattelField) {
        this.battleField = battleField;
    }

    public String scanQuadrant (int y, int x) {
        return battleField[y][x];
    }

    public void updateQuadrant (int y, int x, String object) {
        battleField[y][x] = object;
    }

    public int getDimentionX () {
        return battleField[0].length;
    }

    public int getDimentionY () {
        return battleField.length;
    }

    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }
}
