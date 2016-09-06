package Lesson_4.Frame_3.HashCode;

import static org.omg.IOP.TAG_ORB_TYPE.value;

public class Person {

    private String name;
    private int age;
    private long salary;

    Person () {

    }

    @Override
    public int hashCode() {
        final int perem = 37;
        int rez = 10;

        if (name == null) {
            rez = perem * rez + ((Integer) age).hashCode();
            rez = perem * rez + ((Long) salary).hashCode();
        } else {
            rez = perem * rez + name.hashCode();
            rez = perem * rez + ((Integer) age).hashCode();
            rez = perem * rez + ((Long) salary).hashCode();
        }
        return rez;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Person)) {
            return false;
        }
        Person pers = (Person) obj;
        return (name != null && name.equals(pers.getName()) && (age == pers.getAge() && salary == pers.getSalary()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
