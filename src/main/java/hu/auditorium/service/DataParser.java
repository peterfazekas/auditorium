package hu.auditorium.service;

import hu.auditorium.model.Category;
import hu.auditorium.model.Position;
import hu.auditorium.model.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class DataParser {
    private static final char OCCUPIED = Resources.OCCUPIED;
    private static final int FIRST_ITEM = Resources.FIRST_ITEM;
    private static final String EMPTY = Resources.EMPTY;
    private static final int OFFSET = Resources.OFFSET;
    private static final String SEPARATOR = Resources.SEPARATOR;

    private final List<String> occupiedList;
    private final List<String> categoryList;

    public DataParser(final List<String> occupiedList, final List<String> categoryList) {
        this.occupiedList = occupiedList;
        this.categoryList = categoryList;
    }

    public List<Seat> parser() {
        List<Seat> seats = new ArrayList<>();
        for (int row = FIRST_ITEM; row < occupiedList.size(); row++) {
            String seatOccupancy = occupiedList.get(row);
            String seatCategory = categoryList.get(row);
            for (int seatNumber = FIRST_ITEM; seatNumber < occupiedList.get(FIRST_ITEM).length(); seatNumber++) {
                Position position = new Position(row + OFFSET, seatNumber + OFFSET);
                int categoryId = Integer.parseInt(seatCategory.charAt(seatNumber) + EMPTY);
                Category category = Category.setCategory(categoryId);
                boolean occupied = seatOccupancy.charAt(seatNumber) == OCCUPIED;
                Seat seat = new Seat(position, category, occupied);
                seats.add(seat);
            }
        }
        return seats;
    }

    public Position getPosition() {
        Console console = new Console();
        String line = console.readLine();
        String[] data = line.split(SEPARATOR);
        int row = Integer.parseInt(data[0]);
        int column = Integer.parseInt(data[1]);
        return new Position(row, column);
    }
}
