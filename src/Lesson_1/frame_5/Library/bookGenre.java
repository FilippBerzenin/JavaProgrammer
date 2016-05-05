package Lesson_1.frame_5.Library;

/**
 * Created by Samsung on 27.04.2016.
 */
public enum bookGenre {
    FANTASY, FOOD, COMPUTERS, FICTIONS, HISTORY, SCINTIFIC, KIDS;

    public static bookGenre value (int i) {
        bookGenre[] genre = bookGenre.values();
        return genre[i];
    }

}
