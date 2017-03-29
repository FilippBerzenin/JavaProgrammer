package Lesson_5.Frame_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateOfBirthday {

    public static void main(String args[]) throws Exception {

        Date day = new Date();
        System.out.println(day);

        SimpleDateFormat sdf = new SimpleDateFormat ("dd MMM yyyy");
        System.out.println(sdf.format(day));

        Date birthday = sdf.parse("15 07 1982");
        System.out.println(sdf.format(birthday));


    }

}


