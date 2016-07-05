package Lesson_3.Frame_1;

import static java.lang.Thread.sleep;

public class Exceptionn extends RuntimeException {

    public static void main(String[] args) {
        System.out.println("Start");

        try {
            catchException();
            nullPointerException ();
        }
        catch (InterruptedException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Do samething with me");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("!!!Ok!!!");
        }
//        catch (IllegalArgumentException e) {
//            System.out.println("Are you stupid?");
//            e.printStackTrace();
//        }

        System.out.println("Finish");
    }

    public static void catchException() throws InterruptedException {
//        currentThread().interrupt();
        Thread.sleep(1000);
    }

    public static void nullPointerException () throws Exception {
        int[] array = new int[5];

        for (int i = 0; i<array.length; i++) {
            array[i]=i+1;
            if (array[i]>2) {
                throw new Exception("Bad i");
            }
            System.out.print(array[i]);
        }

        Exceptionn[] ex = new Exceptionn[5];

        for (int i = 0; i<ex.length; i++) {
            if (ex[i].equals("qed")) {
                System.out.println("Vau");
            }
        }
    }
}
