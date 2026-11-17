package domain;

import java.util.ArrayList;
import java.util.List;

import util.IdManager;

public abstract class MenuItem {

    protected String id;
    private String name;
    private String description;
    private double price;

        private static final List<String> existingIds = new ArrayList<>();
    
    public MenuItem(int numericId, String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setId(numericId);
    }

    ///// BASIC GETTERS AND SETTERS /////
    
    public abstract String getId();
    public abstract String getPrefix();

    public void setId(int numericId) {
        this.id = IdManager.generateAndRegisterId(numericId, getPrefix(), getId(), existingIds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Menu item Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Menu Item Description cannot be empty.");
        }
        this.description = description.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Menu Item PRICE must be greater than 0.");
        }
        this.price = price;
    }

    ///// DOMAIN METHODS /////
    public static void unregisterId(String id) {
        existingIds.remove(id);
    }
}
