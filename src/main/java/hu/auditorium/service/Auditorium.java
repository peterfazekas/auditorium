package hu.auditorium.service;

import hu.auditorium.model.Category;
import hu.auditorium.model.Position;
import hu.auditorium.model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Fazek on 2017.02.19..
 */
public class Auditorium {
    private static final int FIRST_ITEM = DataParser.FIRST_ITEM;

    private List<Seat> seats;
    private Map<Category, Integer> categoryCount;

    public Auditorium(List<Seat> seats) {
        this.seats = seats;
        categoryStatistic();
    }

    private void categoryStatistic() {
        categoryCount = new TreeMap<>();
        seats.forEach(s -> {
            Category category = s.getCategory();
            int value = categoryCount.containsKey(category) ? categoryCount.get(category) : 0;
            categoryCount.put(category, ++value);
        });
    }

    public String isSeatOccupied(Position position) {
        Boolean occupied = null;
        for (Seat seat : seats) {
            if(seat.getPosition().equals(position)) {
                occupied = seat.isOccupied();
            }
        }
        return occupied ? OutputText.LINE[0] : OutputText.LINE[1];
    }

    public String getAudienceStatistic() {
        long max = seats.size();
        long counter = seats.stream()
                .filter(i -> i.isOccupied())
                .count();
        double percent = (double) counter * 100 / max;
        return String.format(OutputText.LINE[2], counter, percent);
    }

    public String getMaxCategoryId() {
        Category maxCategory = Category.setCategory(1);
        int max = categoryCount.get(maxCategory);
        for (Map.Entry<Category, Integer> category : categoryCount.entrySet()) {
            if(category.getValue() >= max) {
                max = category.getValue();
                maxCategory = category.getKey();
            }
        }
        return String.format(OutputText.LINE[3], maxCategory.getId());
    }

    public String getTotalPriceOfSoldTickets() {
        int total = 0;
        for (Map.Entry<Category, Integer> category : categoryCount.entrySet()) {
            total += category.getKey().getPrice() * category.getValue();
        }
        return String.format(OutputText.LINE[4], total);
    }

    public List<String> getFreeSeatCategoryMap() {
        List<String> freeSeats = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int row = seats.get(FIRST_ITEM).getPosition().getRow();
        for (Seat seat : seats) {
            int actualRow = seat.getPosition().getRow();
            if(actualRow != row) {
                row = actualRow;
                freeSeats.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(seat.toString());
        }
        freeSeats.add(sb.toString());
        return freeSeats;
    }
}
