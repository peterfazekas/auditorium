package hu.auditorium.data.read;

import hu.auditorium.view.Resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class AuditoriumFileReader implements Reader {

    private static final String PATH = Resources.PATH;

    public List<String> read(final String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
