package hu.auditorium.datalogger;

import java.util.List;

/**
 * Created by Fazek on 2017.02.19..
 */
public interface Logger {

    void printAllLine(List<String> lines);
    void println(String text);
}
