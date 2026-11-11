package domain;

import java.util.ArrayList;

public class FoodItem extends MenuItem {
    private String id;

    private static final ArrayList<String> existingIds = new ArrayList<>();

    public FoodItem(int id, String name, String description, double price) {
        super(name, description, price);
        setId(id);
    }

    ///// BASIC GETTERS AND SETTERS /////

    public String getId() {
        return id;
    }

    public void setId(int numericId) {
        if (numericId < 0) {
            throw new IllegalArgumentException("ID number cannot be negative.");
        }
        String formatedId = String.format("FI%03d", numericId);

        if (existingIds.contains(formatedId)) {
            throw new IllegalArgumentException("The ID " + formatedId + " is already in use.");

        }

        if(this.id != null) {
            existingIds.remove(this.id);
        }

        existingIds.add(formatedId);
        this.id = formatedId;
    }
}
