package Lesson_4.Frame_2.OurList.addAfter;

public class SimplyLinkedList {

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

    public void addAfterObject (Object o, Object prev) {

    }

    public int size () {
        return size;
    }

    private class Node {
        Object o;
        Node node;
    }
}
