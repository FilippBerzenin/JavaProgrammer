package Lesson_1.frame_5.TankLauncher;

public class BattelField {
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    String[][] battleField = {
            {"B", "B", "B", "B", "B", "B", "B", "B", "B"},
            {"B", " ", " ", " ", " ", " ", " ", " ", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", "B", "B", " ", "B", " ", "B", "B", "B"},
            {"B", "B", " ", "B", "B", "B", " ", "B", "B"},
            {"B", "B", " ", " ", " ", " ", " ", "B", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"},
            {"B", " ", " ", "B", "B", "B", " ", " ", "B"}
    };

    public BattelField () {

    }

    public BattelField (String [][] BattelField) {
        this.battleField = battleField;
    }

    public String scanquadrant (int y, int x) {
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
