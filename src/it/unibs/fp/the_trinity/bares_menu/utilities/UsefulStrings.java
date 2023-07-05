package it.unibs.fp.the_trinity.bares_menu.utilities;

/**
 * @author Baresi Marco
 */
public class UsefulStrings {
    public static final String[] ERROR_STRINGS = {
            "Errore di inserimento. That's what she said.",
            "Si e' verificato un problema. Reinstalla il Sistema Operativo.",
            "Non dovresti non inserire un dato non invalido.",
            "Inserire un dato valido.",
            "ERROR 404 (NOT FOUND)",
            "ERRORE ERRORE ERRORE",
            "Cadiamo solo per imparare a rialzarci.",
    };

    public static final String[] GOODBYE_STRINGS = {
            "Se hai rilevato qualche bug, inviaci una mail all'indirizzo movetotrash@tmpmail.com",
            "Addioo, addiooo, aamici aaddio \nNoi ciiiiiiiii dobbiamo laasciaaaree \nMa ehi, io dico, che e' oookkeey!",
            "See You Space Cowboy.",
            "ARI ARI ARI ARI ARI ARI Arrivederci!"
    };

    public static String getErrorString() {
        return ERROR_STRINGS[(int) (Math.random() * ERROR_STRINGS.length)];
    }

    public static String getGoodbyeString() {
        return GOODBYE_STRINGS[(int) (Math.random() * GOODBYE_STRINGS.length)];
    }
}