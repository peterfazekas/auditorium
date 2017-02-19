package hu.auditorium.service;

import hu.auditorium.model.Seat;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Neighbor {

    private static final int OFFSET = Resources.OFFSET;

    private final List<Seat> seats;

    public Neighbor(final List<Seat> seats) {
        this.seats = seats;
    }

    public boolean isSingleFreeSeat(final int index) {
        Seat seat = seats.get(index);
        boolean neighbour = false;
        if (!seat.isOccupied()) {
            int counter = OFFSET;
            counter += seat.hasLeftNeighbour() ? inCement(seats.get(index - OFFSET)) : 0;
            counter += seat.hasRightNeighbour() ? inCement(seats.get(index + OFFSET)) : 0;
            neighbour = counter == OFFSET ? true : false;
        }
        return neighbour;
    }

    private int inCement(final Seat seat) {
        return !seat.isOccupied() ? OFFSET : 0;
    }
}
