package hu.auditorium.view;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Resources {
    public static final String PATH = "src\\main\\resources\\";
    public static final Character OCCUPIED = 'x';
    public static final int FIRST_ITEM = 0;
    public static final String EMPTY = "";
    public static final String SEPARATOR = " ";
    public static final int LEFT_SIDE = 1;
    public static final int RIGHT_SIDE = 20;
    public static final int OFFSET = 1;

    public static final String[] LINE = {
            "   A kiválasztott hely már foglalt.",
            "   A kiválasztott hely még üres.",
            "Az előadásra eddig %d jegyet adtak el, ez a nézőtér %d%%-a.",
            "A legtöbb jegyet a(z) %d. árkategóriában értékesítettek.",
            "A pillanatnyilag eladott jegyek alapján a színház bevétele: %d Ft.",
            "%d darab egyedülálló üres hely van a nézőtéren"};
}
