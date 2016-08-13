package Lesson_3.Frame_3.Tank.CoffeeShop;

public class Menu extends Products {

    private Products[] name = new Products[15];

    Menu() {
        menu();
    }

    private void menu() {

        name[0] = new Products("BLACKCOFFEE", Ingidienta.WATER, Ingidienta.COFFEE, Ingidienta.WORK);
        name[1] = new Products("COFFEEWITHMILK", Ingidienta.WATER, Ingidienta.COFFEE, Ingidienta.MILK, Ingidienta.WORK);
        name[2] = new Products("COFEEOFAMERICANO", Ingidienta.WATER, Ingidienta.WATER, Ingidienta.COFFEE, Ingidienta.WORK);
        name[3] = new Products("CAPUCCHINO", Ingidienta.WATER, Ingidienta.MILK, Ingidienta.MILK, Ingidienta.COFFEE, Ingidienta.WORK);
        name[4] = new Products("MOKACCINO", Ingidienta.WATER, Ingidienta.MILK, Ingidienta.MILK, Ingidienta.COFFEE, Ingidienta.CHOCOLATE, Ingidienta.WORK);
        name[5] = new Products("BLACKTEA", Ingidienta.WATER, Ingidienta.TEA, Ingidienta.SUGAR, Ingidienta.WORK);
        name[6] = new Products("GREENTEA", Ingidienta.WATER, Ingidienta.GREENTEA, Ingidienta.SUGAR, Ingidienta.WORK);
        name[7] = new Products("TRAWITHBERGAMOT", Ingidienta.WATER, Ingidienta.TEA, Ingidienta.SUGAR, Ingidienta.BERGAMOT, Ingidienta.WORK);
        name[8] = new Products("Keks", 5.5);
        name[9] = new Products("Water", Ingidienta.WATER, Ingidienta.WATER, Ingidienta.WATER, Ingidienta.WORK);
    }

    public Products[] getName() {
        return name;
    }

    public void setName(Products[] name) {
        this.name = name;
    }
}
