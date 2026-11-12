package domain;

import java.util.ArrayList;

public class BeverageItem extends MenuItem {
    private Boolean containsAlcohol;
    private double volumeMl;        
    
    private static final ArrayList<String> existingIds = new ArrayList<>();

    public BeverageItem(int numericId, String name, String description, double price, Boolean containsAlcohol,
            double volumeMl) {
        super(numericId, name, description, price);
        setContainsAlcohol(containsAlcohol);
        setVolumeMl(volumeMl);
    }

    ///// BASIC GETTERS AND SETTERS /////
    @Override
    public String getId() {
        return this.getId();
    }

    @Override
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

    public boolean isContainsAlcohol() {
        return containsAlcohol;
    }

    public void setContainsAlcohol(Boolean containsAlcohol) {
        if (containsAlcohol == null) {
            throw new IllegalArgumentException("The alcohol field cannot be empty.");
        }
        this.containsAlcohol = containsAlcohol;
    }

    public double getVolumeMl() {
        return volumeMl;
    }

    public void setVolumeMl(double volumeMl) {
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("The volume of the beverage must be greather than 0.");
        }
        this.volumeMl = volumeMl;
    }

    ///// DOMAIN METHODS /////
    private String getPrefix() {
        return "BI"; // Beverage Item -> BI
    }
}
