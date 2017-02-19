package hu.auditorium.datalogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class AuditoriumLogger implements Logger{

    private final String fileName;

    public AuditoriumLogger(final String fileName) {
        this.fileName = fileName;
        File log = new File(fileName);
        log.delete();
    }

    @Override
    public void printAllLine(List<String> lines) {
        lines.forEach(line -> println(line));
    }

    @Override
    public void println(String text) {
        try (PrintWriter file = new PrintWriter(new FileWriter(fileName, true))){
            file.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
