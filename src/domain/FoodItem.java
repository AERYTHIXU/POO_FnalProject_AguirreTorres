package domain;

import java.util.ArrayList;

public class FoodItem extends MenuItem {

    private static final ArrayList<String> existingIds = new ArrayList<>();

    public FoodItem(int numericId, String name, String description, double price) {
        super(numericId, name, description, price);
        setId(numericId);
    }

    ///// BASIC GETTERS AND SETTERS /////
    @ Override
    public String getId() {
        return this.getId();
    }

    @ Override
    public void setId(int numericId) {
        if (numericId < 0) {
            throw new IllegalArgumentException("ID number cannot be negative.");
        }
        String formatedId = String.format("%s%03d", this.getPrefix(), numericId);

        if (existingIds.contains(formatedId)) {
            throw new IllegalArgumentException("The ID " + formatedId + " is already in use.");

        }

        if(this.getId() != null) {
            existingIds.remove(this.getId());
        }

        existingIds.add(formatedId);
        this.id = formatedId;
    }

    ///// DOMAIN METHODS /////
    private String getPrefix() {
        return "FI"; // Food Item -> FI
    }
}
