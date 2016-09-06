package Lesson_4.Frame_3.HashCode;

import static org.omg.IOP.TAG_ORB_TYPE.value;

public class Person {

    private String name;
    private int age;
    private long salary;
    private Adress a;

    Person () {

    }

    @Override
    public int hashCode() {
        int rezalt = 25;
            rezalt = 37 * rezalt + name.hashCode();
            rezalt = 37 * rezalt + ((Integer) age);
            rezalt = 37 * rezalt +  new Long (salary).hashCode();
            rezalt = 37 * rezalt + a.hashCode();
        return rezalt;
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

    public Adress getA(String n, String b, int c) {
        Adress a = new Adress(n, b, c);
        return a;
    }

    public void setA(Adress a) {
        this.a = a;
    }
}
