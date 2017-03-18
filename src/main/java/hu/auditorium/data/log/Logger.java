package hu.auditorium.data.log;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public interface Logger {

    void printAllLine(final List<String> lines);
    void println(final String text);
}
