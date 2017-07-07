package Lesson_6.Frame_2.Subsrible_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Product extends Observable {

        private List<Subscriber> subscribers;
        private String name;

                public Product(String name) {
                subscribers = new ArrayList<>();
                this.name = name;
            }

                public void newEdition() {

                    setChanged();
                    notifyObservers(name);

                    }

    public String getName() {
        return name;
    }
}

