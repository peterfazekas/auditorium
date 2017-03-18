package hu.auditorium.service;

import hu.auditorium.data.read.Reader;
import hu.auditorium.model.Category;
import hu.auditorium.model.Position;
import hu.auditorium.model.Seat;
import hu.auditorium.view.Resources;
import hu.auditorium.view.Sources;

import java.util.ArrayList;
import java.util.List;

/**
 * Create List of {@link Seat} from List of Strings.
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

    public DataParser(final Reader file) {
        this.occupiedList = file.read(Sources.OCCUPIED.getSource());
        this.categoryList = file.read(Sources.CATEGORY.getSource());
    }

    public List<Seat> parser() {
        List<Seat> seats = new ArrayList<>();
        for (int row = FIRST_ITEM; row < occupiedList.size(); row++) {
            for (int seatNumber = FIRST_ITEM; seatNumber < occupiedList.get(FIRST_ITEM).length(); seatNumber++) {
                seats.add(createSeat(row, seatNumber));
            }
        }
        return seats;
    }

    private Seat createSeat(final int row, final int seatNumber) {
        Position position = new Position(row + OFFSET, seatNumber + OFFSET);
        String seatCategory = categoryList.get(row);
        int categoryId = Integer.parseInt(seatCategory.charAt(seatNumber) + EMPTY);
        Category category = Category.setCategory(categoryId);
        String seatOccupancy = occupiedList.get(row);
        boolean occupied = seatOccupancy.charAt(seatNumber) == OCCUPIED;
        return new Seat(position, category, occupied);
    }

    public Position getPosition(final String line) {
        String[] data = line.split(SEPARATOR);
        int row = Integer.parseInt(data[0]);
        int column = Integer.parseInt(data[1]);
        return new Position(row, column);
    }
}
