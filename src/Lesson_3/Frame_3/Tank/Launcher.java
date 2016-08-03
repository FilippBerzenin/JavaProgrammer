package Lesson_3.Frame_3.Tank;

public class Launcher {

    public static void main (String[] args) throws Exception {
        try {
            return;
        } catch (Exception e) {
            e.printStackTrace();}
        finally {
            System.out.println("I want to be executed");
        }
        ActionField af = new ActionField();
        af.runTheGame();
    }
}
