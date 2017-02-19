package hu.auditorium.datalogger;

import hu.auditorium.service.Resources;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class AuditoriumLogger implements Logger{

    private static final String PATH = Resources.PATH;

    private final String fileName;

    private AuditoriumLogger(final String fileName) {
        this.fileName = fileName;
        File log = new File(fileName);
        log.delete();
    }

    @Override
    public void printAllLine(final List<String> lines) {
        lines.forEach(line -> println(line));
    }

    @Override
    public void println(final String text) {
        try (PrintWriter file = new PrintWriter(new FileWriter(PATH + fileName, true))){
            file.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
