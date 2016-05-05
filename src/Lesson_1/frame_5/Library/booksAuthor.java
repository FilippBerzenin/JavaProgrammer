package Lesson_1.frame_5.Library;

public enum booksAuthor {

    ARTUR_CONAN_DOIL(1), RAY_BREDBERY(2), YAKOV_FAIN(3), STANISLAV_LEM(4), BRATYA_STRUGACKIY(5), MAIKAL_MURKOK(6),
    GERMAN_GESSE(7), STANISLAV_SENKEVICH(8), FEDOR_DOSTEVSKIY(9), ALEXANDR_PUSHKIN(10), LEV_TOLSTOY(11);

    private int id;

    private booksAuthor(int id) {

    }

    public static booksAuthor value (int i) {
        booksAuthor[] authors = booksAuthor.values();
        return authors[i];
    }
}
