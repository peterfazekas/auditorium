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
    private static final char OCCUPIED = Seat.OCCUPIED;
    public static final int FIRST_ITEM = 0;
    public static final String EMPTY = "";

    private static final int OFFSET = 1;

    private List<String> occupiedList;
    private List<String> categoryList;

    public DataParser(List<String> occupiedList, List<String> categoryList) {
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

}
