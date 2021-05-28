package it.unibs.fp.the_trinity.bares_menu;

public class EntryPoint {
    public static void main (String... args) {
        Runnable r1 = () -> System.out.println("Primo runnable");
        Runnable r2 = () -> System.out.println("Secondo runnable");
        Runnable r3 = () -> System.out.println("Terzo runnable");

        Item[] items = new Item[3];
        items[0] = new Item("Prima opzione, serve per testare il frame", r1);
        items[1] = new Item("Seconda opzione", r2);
        items[2] = new Item("Terza opzione", r3);

        Menu menu = new Menu("Titolo", items);
        menu.run();
    }
}
