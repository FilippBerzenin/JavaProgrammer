package Lesson_3.Frame_3.Tank.Code;

public class exeption {

    public static void main (String[] args) {
        exept();
        System.out.println("The end");
    }

    private static void exept () {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new IllegalStateException();}
        finally {
            System.out.println("I want to be executed");
        }
    }
}
