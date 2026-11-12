package domain;

public abstract class MenuItem {
    protected String id;
    private String name;
    private String description;
    private double price;
    
    public MenuItem(int numericId, String name, String description, double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setId(numericId);
    }

    ///// BASIC GETTERS AND SETTERS /////
    
    public abstract String getId();
    public abstract void setId(int id);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Menu item Name cannot be empty.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
