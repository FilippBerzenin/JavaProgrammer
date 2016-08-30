package Lesson_4.Frame_1.ClassRoom.ClassroomEqualse;

public class Student {

    String name;
    String surname;

    Student() {

    }

    Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.name == name && this.surname == surname) {
            return true;
        }
        else return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
