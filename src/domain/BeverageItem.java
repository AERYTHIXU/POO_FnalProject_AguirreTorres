package domain;

public class BeverageItem extends MenuItem {
    private Boolean containsAlcohol;
    private double volumeMl;        

    private static final String PREFIX = "BI"; // Beverage Item -> BI

    
    public BeverageItem(int numericId, String name, String description, double price, Boolean containsAlcohol,
            double volumeMl) {
        super(numericId, name, description, price);
        setContainsAlcohol(containsAlcohol);
        setVolumeMl(volumeMl);
    }

    ///// BASIC GETTERS AND SETTERS /////
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(int numericId) {
        super.setId(numericId);
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

    @Override
    public String getPrefix() {
        return PREFIX;
    }
}
