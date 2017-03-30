package Lesson_5.Frame_2.newFrame;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calend {

    public static void main (String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(1982,6,15);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String dow = sdf.format(c.get(Calendar.DAY_OF_WEEK));

        System.out.println(dow);
    }
}
