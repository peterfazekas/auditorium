package hu.auditorium.model;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public enum Category {
    FIRST(1, 5000), SECOND(2, 4000), THIRD(3, 3000), FOURTH(4, 2000), FIFTH(5, 1500);

    private final int id;
    private final int price;

    Category(final int id, final int value) {
        this.id = id;
        this.price = value;
    }

    public static Category setCategory(final int id) {
        for (Category category : Category.values()) {
            if(category.id == id) {
                return category;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
