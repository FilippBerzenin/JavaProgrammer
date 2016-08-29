package Lesson_4.Frame_1.ClassRoom;

public class launcher {

    private Classroom cr = new Classroom();

    public static void main (String[] args) {
        Classroom cr = new Classroom();

        cr.makeClass();
        cr.enter();
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.leave("Filipp", "Berzenin");
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent("Vasiliy", "Berzenin");
    }
}
