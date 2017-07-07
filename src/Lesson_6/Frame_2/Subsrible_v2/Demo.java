package Lesson_6.Frame_2.Subsrible_v2;

public class Demo {

    public static void main (String[] args) {
        Product p1 = new Newspaper("IT news");
        Product p2 = new Newspaper("Cats & Dogs");
        Product p3 = new Magazine("Playboy");

        Subscriber s1 = new Subscriber();
        Subscriber s2 = new Subscriber();

        p1.addObserver(s1);
        p2.addObserver(s1);
        p2.addObserver(s2);
        p3.addObserver(s2);

        p1.newEdition();
        System.out.println();

        p2.newEdition();
        System.out.println();

        p3.newEdition();
    }
}
