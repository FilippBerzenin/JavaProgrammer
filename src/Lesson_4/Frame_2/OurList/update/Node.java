package Lesson_4.Frame_2.OurList.update;

import java.util.Objects;

public class Node {

    private Objects o;
    private Node node;

    Node() {

    }

    public Objects getO() {
        return o;
    }

    public void setO(Objects o) {
        this.o = o;
    }

    public Node getNote() {
        return node;
    }

    public void setNote(Node note) {
        this.node = note;
    }
}
