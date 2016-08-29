package Lesson_4.Frame_1.ClassRoom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;

    public void makeClass() {
        students=new ArrayList<>();
    }

    public void enter () {
        students.add(new Student("Filipp","Berzenin "));
        students.add(new Student("Kantemir","Berzenin"));
        students.add(new Student("Timophey","Berzenin"));
        students.add(new Student("Vasiliy","Berzenin"));
    }

    public void leave(String name, String surname) {
        int index = numberOfStudent(name, surname);
        if (index >= 0) {
            students.remove(index);
            System.out.println("Student " + name +" " + surname+ "is leave a classroom.");
            System.out.println();
        }

    }

    public void getStudentsCount () {
        int count;
        count = students.toArray().length;
        System.out.println("Present in classroom now - "+count);
        System.out.println();
    }

    public int numberOfStudent (String name, String surname) {
        int i;
        for (i = 0; i < students.toArray().length; i++) {
            if (students.get(i).getName().equals(name) && students.get(i).getSurname().equals(surname)) {
                return i;
            }
        }
        return 0;
    }

    public void isPresent(String name, String surname) {
        boolean present = false;
        if (numberOfStudent (name, surname)>0) {
         present = true;
        }
        if (present == true) {
            System.out.println("Ok!" + name + " " + surname + " is present!");
        } else {
            System.out.print("Absent");
        }
    }


    public void printStudentInfo () {
        System.out.println("-------Present in classroom-------");
        for (int i = 0;i<students.toArray().length; i++) {
            System.out.println(students.get(i).getName() + " " + students.get(i).getSurname());
        }
        System.out.println();
    }

    public void getStudent () {

    }

}
