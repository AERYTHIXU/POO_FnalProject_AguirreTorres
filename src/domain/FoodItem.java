package domain;

public class FoodItem extends MenuItem {

    private static final String PREFIX = "FI"; // Food Item -> FI

    public FoodItem(int numericId, String name, String description, double price) {
        super(numericId, name, description, price);
    }

    ///// BASIC GETTERS AND SETTERS /////
    @ Override
    public String getId() {
        return id;
    }

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}

