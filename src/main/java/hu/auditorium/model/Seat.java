package hu.auditorium.model;

/**
 * Created by Fazek on 2017.02.19..
 */
public class Seat {
    public static final Character OCCUPIED = 'x';

    private Position position;
    private Category category;
    private boolean occupied;

    public Seat(Position position, Category category, boolean occupied) {
        this.position = position;
        this.category = category;
        this.occupied = occupied;
    }

    public Position getPosition() {
        return position;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public String toString() {
        return occupied ? OCCUPIED.toString() : category.getId().toString();
    }
}
