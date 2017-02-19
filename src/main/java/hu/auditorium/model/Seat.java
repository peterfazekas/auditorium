package hu.auditorium.model;

import hu.auditorium.service.Resources;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Seat {
    private static final Character OCCUPIED = Resources.OCCUPIED;

    private final Position position;
    private final Category category;
    private final boolean occupied;

    public Seat(final Position position, final Category category, final boolean occupied) {
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

    public boolean hasLeftNeighbour() {
        return position.hasLeftNeighbour();
    }

    public boolean hasRightNeighbour() {
        return position.hasRightNeighbour();
    }

    @Override
    public String toString() {
        return occupied ? OCCUPIED.toString() : category.getId().toString();
    }
}
