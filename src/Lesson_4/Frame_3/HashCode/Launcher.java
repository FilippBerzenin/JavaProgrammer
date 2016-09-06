package Lesson_4.Frame_3.HashCode;

public class Launcher {

    Person p;

    public static void main (String[] args) {

        Person fil = new Person();
        fil.setName("Fil");
        fil.setAge(34);
        fil.setSalary(10000);

        Person kant = new Person();
        fil.setName("Kant");
        fil.setAge(36);
        fil.setSalary(10000);

        Person vika = new Person();
        fil.setName("Vika");
        fil.setAge(33);
        fil.setSalary(10000);

        System.out.println (fil.getName() + fil.hashCode());
        System.out.println (kant.getName() + kant.hashCode());
        System.out.println (vika.getName() + vika.hashCode());
    }
}
