package it.unibs.fp.the_trinity.bares_menu;

public class Item {
    private String text;
    private Runnable function;

    public Item(String text, Runnable function) {
        this.text = text;
        this.function = function;
    }


    public String getText() {
        return text;
    }

    public Runnable getFunction() {
        return function;
    }
}
