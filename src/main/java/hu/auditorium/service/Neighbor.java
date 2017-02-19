package hu.auditorium.service;

import hu.auditorium.model.Seat;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Neighbor {

    private final List<Seat> seats;


    public Neighbor(final List<Seat> seats) {
        this.seats = seats;
    }

    public boolean isSingleFreeSeat(int index) {
        Seat seat = seats.get(index);
        boolean neighbour = false;
        if (!seat.isOccupied()) {
            int counter = 1;
            if (seat.hasLeftNeighbour()) {
                Seat left = seats.get(index - 1);
                if (!left.isOccupied()) {
                    counter++;
                }
            }
            if (seat.hasRightNeighbour()) {
                Seat right = seats.get(index + 1);
                if (!right.isOccupied()) {
                    counter++;
                }
            }
            neighbour = counter == 1 ? true : false;
        }
        return neighbour;
    }
}
