package Lesson_1.frame_5.Library;

import java.util.Random;

public class book {

    private String bookName;
    private bookGenre genre;
    private booksAuthor author;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public bookGenre getGenre() {
        return genre;
    }

    public void setGenre(bookGenre genre) {
        this.genre = genre;
    }

    public booksAuthor getAuthor() {
        return author;
    }

    public void setAuthor(booksAuthor author) {
        this.author = author;
    }

    public void setBookName(int i) {
        bookName = Integer.toString(i);

    }

    public void setGenre() {
        int i;
        i = random(7);
        setGenre(bookGenre.value(i));
    }

    public void setAuthor() {
        int i;
        i = random(11);
        setAuthor(booksAuthor.value(i));
    }

    private static int random (int k) {
        Random r = new Random();
        int i = 0;
        i = r.nextInt(k);
        return i;
    }

}
