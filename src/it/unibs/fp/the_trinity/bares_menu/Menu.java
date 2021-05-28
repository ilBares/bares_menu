package it.unibs.fp.the_trinity.bares_menu;

import it.unibs.fp.the_trinity.utilities.DataInput;
import it.unibs.fp.the_trinity.utilities.Time;

import java.util.TreeMap;

/**
 * Customizable console {@code Menu}.
 *
 * @author Baresi Marco
 */
public class Menu implements Runnable {
    private String title;
    private TreeMap<String, Item> itemsMap;
    private String endKey = "0";
    private String frame;

    /**
     * Constructs a new {@code Menu} with input {@code Items}.
     *
     * @param items the menu's items
     */
    public Menu(String title, Item[] items) {
        this.title = title;
        itemsMap = new TreeMap<>();
        for (int i=0; i<items.length; i++) {
            itemsMap.put((i+1)+"", items[i]);
        }
    }

    @Override
    public void run() {
        generateFrame();
        String choice;
        do {
            printTitle();
            printOptions();
            System.out.println(frame);
            choice = DataInput.readNotEmptyString("» ");
            if (itemsMap.containsKey(choice))
                itemsMap.get(choice).getFunction().run();
            else if (!choice.equals(endKey)) {
                System.out.println("♿22 Scelta non valida");
                Time.pause(Time.HIGH_MILLIS_PAUSE);
            }
        } while (!choice.equals(endKey));
    }

    private void printOptions() {
        for (String key : itemsMap.keySet()) {
            System.out.println("[" + key + "]: " + itemsMap.get(key).getText());
        }
        System.out.println("[" + endKey + "]: " + "EXIT");
    }

    /**
     * This method allows to change a keyValue value. Return {@code true} if {@link #itemsMap}
     * does not contain a key with the same value and the key will be replaced.
     *
     * @param oldKey old key value to replace
     * @param newKey new key value
     * @return {@code true} if endKey was replaced;
     *         {@code false} otherwise
     */
    public boolean changeChoiceKey(String oldKey, String newKey) {
        if (!itemsMap.containsKey(oldKey) || itemsMap.containsKey(newKey) || newKey.equals(endKey))
            return false;
        itemsMap.put(newKey, itemsMap.remove(oldKey));
        return true;
    }

    /**
     * This method allows to change endKey value. Return {@code true} if {@link #itemsMap}
     * does not contain a key with the same value.
     *
     * @param newEndKey new endKey value
     * @return {@code true} if endKey was replaced;
     *         {@code false} otherwise
     */
    public boolean changeEndKey(String newEndKey) {
        if (itemsMap.containsKey(newEndKey))
            return false;
        endKey = newEndKey;
        return true;
    }

    private void generateFrame() {
        int frameLength = 0;
        int t;
        for (String key : itemsMap.keySet()) {
            t = itemsMap.get(key).getText().length() + ("[" + key + "]: ").length();
            if (t > frameLength)
                frameLength = t;
        }
        if (title.length() > frameLength)
            frameLength = title.length();
        frame = "▬".repeat(frameLength);
    }

    private void printTitle() {
        String tempTitle = "";
        tempTitle += " ".repeat((int)Math.floor((frame.length()-2-title.length())/2.));
        tempTitle += title;
        tempTitle += " ".repeat((int)Math.ceil((frame.length()-2-title.length())/2.));
        System.out.println("▿\n▿\n▿\n▖" + frame.substring(2) + "▗");
        System.out.println("▌" + tempTitle + "▐");
        System.out.println("▘" + frame.substring(2) + "▝");
    }
}
