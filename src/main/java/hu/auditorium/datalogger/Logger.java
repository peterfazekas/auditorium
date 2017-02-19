package hu.auditorium.datalogger;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public interface Logger {

    void printAllLine(List<String> lines);
    void println(String text);
}
