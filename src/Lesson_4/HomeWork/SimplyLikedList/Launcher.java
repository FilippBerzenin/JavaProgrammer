package Lesson_4.HomeWork.SimplyLikedList;

public class Launcher {
    public static void main(String[] args) {
        SimplyArrayList list = new SimplyArrayList();

        //add last
        System.out.println("Add last");
        list.add("Fil1");
        list.add("Fil2");
        list.add("Fil3");
        list.add("Fil4");
        list.add("Fil5");
        list.printList();

        //Create new array
        System.out.println("Create new array + add last");
        list.add("Fil6");
        list.printList();

        //Add first
        System.out.println("Add first");
        list.addFirst("First add");
        list.printList();

        //Add by position
        System.out.println("Add by position...");
        list.addByPosition(6, "Petr");
        list.printList();

        //Not true pozition
        list.addByPosition(9, "Slava");

        //Peint by pozition
        System.out.println("Print by pozition");
        list.printByPositionInList(8);

        //remove object
        System.out.println("Remove object");
        list.remove("Fil6");
        list.printList();

        //remove by position
        System.out.println("Remove by pozition");
        list.remove(new String("Fil6"));
        list.printList();

        list.addFirst(10);
        list.printList();

        list.remove(10);
        list.printList();
        System.out.println();
        System.out.println("++++++++++++");

        for(Object l : list){
            System.out.println(l);
        }

    }
}
