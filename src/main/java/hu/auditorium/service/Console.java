package hu.auditorium.service;

import hu.auditorium.model.Position;
import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Console {

    private final Scanner sc;

    public Console() {
        sc = new Scanner(System.in);
    }

    public String readLine() {
        return sc.nextLine();
    }

}
