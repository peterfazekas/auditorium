package hu.auditorium.service;

import hu.auditorium.model.Category;
import hu.auditorium.model.Position;
import hu.auditorium.model.Seat;

import java.util.*;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Auditorium {
    private static final int OFFSET = Resources.OFFSET;
    private static final int RIGHT_SIDE = Resources.RIGHT_SIDE;

    private final List<Seat> seats;
    private final Map<Category, Integer> categoryCount;

    public Auditorium(final List<Seat> seats) {
        this.seats = seats;
        categoryCount = new TreeMap<>();
        seats.forEach(s -> {
            Category category = s.getCategory();
            int value = categoryCount.containsKey(category) ? categoryCount.get(category) : 0;
            categoryCount.put(category, ++value);
        });
    }

    public String isSeatOccupied(final Position position) {
        Boolean occupied = seats.stream()
                .filter(i -> i.getPosition().equals(position))
                .map(i -> i.isOccupied())
                .findFirst()
                .get();
        return occupied ? Resources.LINE[0] : Resources.LINE[1];
    }

    public String getAudienceStatistic() {
        long counter = seats.stream()
                .filter(i -> i.isOccupied())
                .count();
        return String.format(Resources.LINE[2], counter, counter * 100 / seats.size());
    }

    public String getMaxCategoryId() {
        Map.Entry<Category, Integer> categoryIntegerEntry = categoryCount.entrySet()
                .stream()
                .max(Comparator.comparing(i -> i.getValue()))
                .get();
        return String.format(Resources.LINE[3], categoryIntegerEntry.getKey().getId());
    }

    public String getTotalPriceOfSoldTickets() {

        int total = categoryCount.entrySet()
                .stream()
                .mapToInt(i -> i.getKey().getPrice() * i.getValue())
                .sum();
        return String.format(Resources.LINE[4], total);
    }

    public String countSingleFreeSeats() {
        long count = seats.stream()
                .filter(i -> isSingleFreeSeat(i))
                .count();
        return String.format(Resources.LINE[5], count);
    }


    public List<String> getFreeSeatCategoryMap() {
        StringBuilder sb = new StringBuilder();
        seats.forEach(i -> sb.append(i.toString()));
        return splitStringByNumberOfCharacters(sb.toString(), RIGHT_SIDE);
    }

    private List<String> splitStringByNumberOfCharacters(String text, int numOfCharacters) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < text.length()) {
            lines.add(text.substring(index, Math.min(index + numOfCharacters, text.length())));
            index += numOfCharacters;
        }
        return lines;
    }

    public boolean isSingleFreeSeat(final Seat seat) {
        int index = seats.indexOf(seat);
        boolean neighbour = false;
        if (!seat.isOccupied()) {
            int counter = 0;
            counter += seat.hasLeftNeighbour() ? increment(seats.get(index - OFFSET)) : 0;
            counter += seat.hasRightNeighbour() ? increment(seats.get(index + OFFSET)) : 0;
            neighbour = counter == 0 ? true : false;
        }
        return neighbour;
    }

    private int increment(final Seat seat) {
        return !seat.isOccupied() ? OFFSET : 0;
    }

}
