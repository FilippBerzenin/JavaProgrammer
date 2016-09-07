package Lesson_4.HomeWork.SimplyLikedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack {
    private Object object;

    private LinkedList<Object> l = new LinkedList();

    public Stack() {

    }

    public void push(Object object) {

        public void push (Object object){
            l.addLast(object);
        }

//    public Object pop() {
//
//        return new Object();
//    }

    public Object pop() {
        if (l.size() != 0) {
            Object object = l.getFirst();
            l.removeFirst();
            return object;
        } else {
            throw new NoSuchElementException("An empty array");
        }
    }

        public Object peak () {
            if (l.size() != 0) {
                return l.getFirst();
            } else {
                throw new NoSuchElementException("An empty array");
            }
        }

        return new Object();
}



    public void printList() {
        for (Object o : l) {
            System.out.println(o.toString());
        }
    }
}

