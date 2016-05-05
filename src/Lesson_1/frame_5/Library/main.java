package Lesson_1.frame_5.Library;

import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class Main {

    private static book[] book = new book[100];
    private static int numberOfBook;

    static public void main (String[] args) {
        setBooksArray ();
        printOrder("9", booksAuthor.ALEXANDR_PUSHKIN);
        printOrder(bookGenre.FANTASY);
        printOrder(bookGenre.FANTASY);
        for (int i = 0; i<book.length; i++) {
            System.out.println(book[i].getGenre());
        }

    }

    private static void printOrder(String nameBook, booksAuthor autor) {
        for (int i =0;i<book.length; i++) {
            if (book[i].getAuthor().equals(autor) && book[i].getBookName().equals(nameBook)) {
                System.out.println("Please, are you look this book?");
                System.out.println("№" + (i + 1) + " Name of book: " + book[i].getBookName() + " Books autor: " +
                        book[i].getAuthor() + " Books genre: " + book[i].getGenre());
                System.out.println("-----------------------------");
            }
        }
    }


    private static void setBooksArray() {
        for (int i = 0; i<book.length; i++) {
            book[i] = new book();
            book[i].setBookName(i);
            book[i].setGenre();
            book[i].setAuthor();
        }
        book[5] = new book();
        book[5].setBookName(9);
        book[5].setGenre(bookGenre.FANTASY);
        book[5].setAuthor(booksAuthor.ALEXANDR_PUSHKIN);

        arraySorting ();
    }

    private static void arraySorting () {
        int n = 0;
        for (int i = 0; i < bookGenre.values().length; i++) {
            for (int k = 0; k < book.length; k++) {
                if (book[k].getGenre().equals(bookGenre.value(i))) {
                    book mem = book[n];
                    book[n] = book[k];
                    book[k] = mem;
                    n++;
                }
            }
        }
    }

    private static void printOrder(bookGenre ganre) {
        int h = numberOfBook;
        int k = 0;
        for (int i = h; i<book.length && k<5;i++) {
            h++;
            if (book[i].getGenre().equals(ganre)) {
                k++;
                System.out.println("№" + (i + 1) + " Name of book: " + book[i].getBookName() + " Books autor: " +
                book[i].getAuthor() + " Books genre: " + book[i].getGenre());
            }
        }
        System.out.println("------------------------------");
        numberOfBook=h;
    }

    private static void printOrder() {
        int h = numberOfBook;
        for (int i = 0; i<5;i++, h++) {

                System.out.println("№" + (h + 1) + " Name of book: " + book[h].getBookName() + " Books autor: " +
                        book[h].getAuthor() + " Books genre: " + book[h].getGenre());

        }
        System.out.println("------------------------------");
        numberOfBook=h;
    }
}
