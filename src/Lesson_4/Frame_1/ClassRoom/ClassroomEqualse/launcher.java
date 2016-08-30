package Lesson_4.Frame_1.ClassRoom.ClassroomEqualse;

public class launcher {

    private Classroom cr = new Classroom();

    public static void main (String[] args) {
        Classroom cr = new Classroom();

        cr.makeClass();

        Student FililippBerzenin = new Student();
        FililippBerzenin.setName("Filipp");
        FililippBerzenin.setSurname("Berzenin");
        cr.enter(FililippBerzenin);
        Student KantemirBerzenin = new Student("Kantemir","Berzenin");
        cr.enter(KantemirBerzenin);
        Student TimopheyBerzenin = new Student("Timophey","Berzenin");
        cr.enter(TimopheyBerzenin);
        Student VasiliyBerzenin = new Student("Vasiliy","Berzenin");
        cr.enter(VasiliyBerzenin);

        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.leave(FililippBerzenin);
        cr.printStudentInfo();
        cr.getStudentsCount();
        cr.isPresent("Vasiliy", "Berzenin");
        cr.isContins(TimopheyBerzenin);
    }
}
