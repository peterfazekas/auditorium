package hu.auditorium.service;

import hu.auditorium.model.Position;
import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Console {

    private static final String SEPARATOR = Resources.SEPARATOR;

    private Scanner sc;

    public Console() {
        sc = new Scanner(System.in);
    }

    public Position getPosition() {
        String line = readLine();
        String[] data = line.split(SEPARATOR);
        int row = Integer.parseInt(data[0]);
        int column = Integer.parseInt(data[1]);
        return new Position(row, column);
    }

    private String readLine() {
        return sc.nextLine();
    }

}
