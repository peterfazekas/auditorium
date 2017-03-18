package hu.auditorium.view;

/**
 * Enum for input files.
 * @author Peter_Fazekas on 2017.03.18..
 */
public enum Sources {
    OCCUPIED("foglaltsag.txt"),
    CATEGORY("kategoria.txt");

    private final String source;

    Sources(final String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

}
