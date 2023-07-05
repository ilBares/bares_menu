package it.unibs.fp.the_trinity.bares_menu;

import it.unibs.fp.the_trinity.bares_menu.utilities.MyMenu;
import it.unibs.fp.the_trinity.bares_menu.utilities.MyMenuItem;
import it.unibs.fp.the_trinity.bares_menu.utilities.Tipo;

public class EntryPoint {
    public static void main (String... args) {
        System.out.println(Tipo.valueOf("CIAO"));


        Runnable r1 = EntryPoint::option1;
        Runnable r2 = EntryPoint::option2;
        Runnable r3 = EntryPoint::option3;

        // In MenuItems puoi metterci tutte le opzioni (item) che ti servono - exit e' di default
        MyMenuItem[] items = new MyMenuItem[3];
        items[0] = new MyMenuItem("Prima opzione", r1);
        items[1] = new MyMenuItem("Seconda opzione", r2);
        items[2] = new MyMenuItem("Terza opzione", r3);

        MyMenu menu = new MyMenu("Titolo della mia app", items);
        menu.run();
    }

    private static void option1() {
        System.out.println("Eseguo il Primo runnable, metti al posto di questo println le istruzioni che ti servono");
    }

    private static void option2() {
        System.out.println("Eseguo il Secondo runnable, metti al posto di questo println le istruzioni che ti servono");
    }

    private static void option3() {
        System.out.println("Eseguo il Terzo runnable, metti al posto di questo println le istruzioni che ti servono");
    }
}
