package Lesson_4.Frame_3.HashCode;

public class Launcher {

    Person p;

    public static void main (String[] args) {

        Person fil = new Person();
        fil.setName("Fily");
        fil.setAge(34);
        fil.setSalary(10000);
        fil.getA("Dnepr", "Checherinf", 18);

        Person kant = new Person();
        kant.setName("Kant");
        kant.setAge(36);
        kant.setSalary(10000);
        kant.getA("Dnepr", "Checherinf", 18);

        Person vika = new Person();
        vika.setName("Vika");
        vika.setAge(33);
        vika.setSalary(10000);
        vika.getA("Dnepr", "Checherinf", 18);

        System.out.println (fil.getName() + fil.hashCode());
        System.out.println (kant.getName() + kant.hashCode());
        System.out.println (vika.getName() + vika.hashCode());
    }
}
