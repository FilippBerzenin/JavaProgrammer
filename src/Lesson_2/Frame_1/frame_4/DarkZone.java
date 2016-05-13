package Lesson_2.Frame_1.frame_4;

public class DarkZone {

    public static void main (String[] args) {

        System.out.println(darkZone(2500, 12, 25000000));
    }

    public static int darkZone (int monthlyPayment, int procent, int dreamSum) {
        int sumNow = 0;
        int i = 0;
        double procentIn = (double) procent/100/12;
        for (; sumNow<=dreamSum; i++) {
            sumNow +=  monthlyPayment;
            int procentProfit = (int)((double)sumNow*procentIn);
            sumNow +=  procentProfit;
        }
        System.out.println("Number of month:"+i);
        System.out.println("Number of years:"+i/12+"."+i%12);
        System.out.println("Summa on peposite:"+sumNow);
        return i/12;
    }
}
