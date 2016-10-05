package Lesson_5.Frame_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date {

    public static void main (String[] args) throws ParseException {
        String myDateOfBirth = "15.07.1982";
        SimpleDateFormat formatToParrce = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date d = formatToParrce.parse(myDateOfBirth);
        SimpleDateFormat myBirthDay = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        System.out.println("Date of Birth: " + myBirthDay.format(d));


    }
}
