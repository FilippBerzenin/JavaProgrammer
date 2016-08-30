package Lesson_4.Frame_1.ClassRoom.ClassroomEqualse;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;

    public void makeClass() {
        students=new ArrayList<>();
    }

    public void enter (Student s) {
        students.add(s);
    }

    public void leave(Student s) {
            students.remove(s);
            System.out.println("Student " + s.getName() +" " + s.getSurname()+ "is leave a classroom.");
            System.out.println();
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

    public void isContins(Student s) {
         if (students.contains(s)) {
             System.out.println("Ok");
         }
        else {
             System.out.println("Error");
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
