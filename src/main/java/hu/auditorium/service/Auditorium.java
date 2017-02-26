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

    /**
     * Constructor.
     * @param seats as lists of {@link Seat}
     */
    public Auditorium(final List<Seat> seats) {
        this.seats = seats;
        categoryCount = new TreeMap<>();
        seats.forEach(s -> {
            Category category = s.getCategory();
            int value = categoryCount.containsKey(category) ? categoryCount.get(category) : 0;
            categoryCount.put(category, ++value);
        });
    }

    /**
     * 2. feladat: Megadja, hogy egy adott pozíciójú hely még szabad-e vagy már foglalt!
     * @param position as {@link Position} - a hely pozíciója
     * @return String - a megfelelő válasz
     */
    public String isSeatOccupied(final Position position) {
        Boolean occupied = seats.stream()
                .filter(i -> i.getPosition().equals(position))
                .map(Seat::isOccupied)
                .findFirst()
                .orElse(null);
        return occupied ? Resources.LINE[0] : Resources.LINE[1];
    }

    /**
     * 3. feladat: Határozza meg, hogy hány jegyet adtak el eddig, és ez a nézőtér befogadóképességének hány százaléka!
     * A százalékértéket kerekítse egészre, és az eredményt írassa ki a képernyőre.
     * @return String - a megfelelő válasz
     */
    public String getAudienceStatistic() {
        long counter = seats.stream()
                .filter(Seat::isOccupied)
                .count();
        return String.format(Resources.LINE[2], counter, counter * 100 / seats.size());
    }

    /**
     * 4. feladat: Határozza meg, hogy melyik árkategóriában adták el a legtöbb jegyet!
     * Az eredményt írassa ki a képernyőre.
     * @return String - a megfelelő válasz
     */
    public String getMaxCategoryId() {
        Integer categoryId = categoryCount.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(null)
                .getKey()
                .getId();
        return String.format(Resources.LINE[3], categoryId);
    }

    /**
     * 5. feladat: Mennyi lenne a színház bevétele a pillanatnyilag eladott jegyek alapján?
     * Írassa ki az eredményt a képernyőre!
     * @return String - a megfelelő válasz
     */
    public String getTotalPriceOfSoldTickets() {
        int total = categoryCount.entrySet()
                .stream()
                .mapToInt(i -> i.getKey().getPrice() * i.getValue())
                .sum();
        return String.format(Resources.LINE[4], total);
    }

    /**
     * 6. feladat: Mivel az emberek általában nem egyedül mennek színházba,
     * ha egy üres hely mellett nincs egy másik üres hely is, akkor azt nehezebben lehet értékesíteni.
     * Határozza meg, és írassa ki a képernyőre, hogy hány ilyen "egyedülálló" üres hely van a nézőtéren!
     * @return String - a megfelelő válasz
     */
    public String countSingleFreeSeats() {
        long count = seats.stream()
                .filter(this::isSingleFreeSeat)
                .count();
        return String.format(Resources.LINE[5], count);
    }

    private boolean isSingleFreeSeat(final Seat seat) {
        int index = seats.indexOf(seat);
        boolean neighbour = false;
        if (!seat.isOccupied()) {
            int counter = 0;
            counter += seat.hasLeftNeighbour() ? increment(seats.get(index - OFFSET)) : 0;
            counter += seat.hasRightNeighbour() ? increment(seats.get(index + OFFSET)) : 0;
            neighbour = counter == 0;
        }
        return neighbour;
    }

    private int increment(final Seat seat) {
        return !seat.isOccupied() ? OFFSET : 0;
    }

    /**
     * 7. feladat: A színház elektronikus eladási rendszere az érdeklődőknek
     * az üres helyek esetén a hely árkategóriáját jeleníti meg,
     * míg a foglalt helyeket csak egy "x" karakterrel jelzi.
     * Készítse el ennek megfelelően a fenti adatokat tartalmazó szabad.txt fájlt!
     * @return String - a megfelelő válasz
     */
    public List<String> getFreeSeatCategoryMap() {
        StringBuilder sb = new StringBuilder();
        seats.forEach(i -> sb.append(i.toString()));
        return splitStringByNumberOfCharacters(sb.toString(), RIGHT_SIDE);
    }

    private List<String> splitStringByNumberOfCharacters(final String text, final int numOfCharacters) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < text.length()) {
            lines.add(text.substring(index, Math.min(index + numOfCharacters, text.length())));
            index += numOfCharacters;
        }
        return lines;
    }

}
