package Lesson_4.Frame_2.OurList.addAfter;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.Iterator;

public class SimplyLinkedList implements Iterable <Object> {

    Node root;
    int size;

    SimplyLinkedList () {
        size = 0;
    }

    public void addFirstObject (Object o) {
        Node n = new Node();

        n.o = o;

        if (root != null) {
            n.node = root;
        }

        root = n;
        size++;

    }

    public void addLastObject (Object o) {
        Node n = new Node();
        n.o = o;

        if (root == null) {
            root = n;
        }
        else {
            Node last = root;
            Node cp = root;
            while (cp.node != null) {
                last = cp;
                cp = cp.node;

            }
            last.node = n;
        }
        size++;
    }

    public void addAfterObject (Object obj, Object prev) {
        Node prevPointer = null;
        Node cp = root;

        do {
            if (cp.o == prev) {
                prevPointer = cp;
                break;
            }
            cp = cp.node;
        } while (cp != null && cp.node !=null);

        if (prevPointer == null) {
            throw new IllegalStateException("Bad");
        }

        Node n = new Node();
        n.o = obj;

        if (prevPointer != null) {
            n.node = prevPointer.node;
        }
        prevPointer.node = n;
        size++;

    }

    public int size () {
        return size;
    }

    @Override
    public Iterator<Object> iterator() {
        return null;
    }

    private class Node {
        Object o;
        Node node;
    }

    private class SSLIterrator {

        private void next () {

        }

        private void HasNext () {

        }
    }
}
