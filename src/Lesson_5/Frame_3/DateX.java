package Lesson_5.Frame_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateX {

    public static void main (String[] args) throws ParseException {
        Date day = new Date();
        System.out.println(day);

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        System.out.println(myFormat.format(day));

        Date myBirthDay = myFormat.parse("15.07.1982");
        System.out.println(myBirthDay);


    }
}
