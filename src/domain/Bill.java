package domain;

import java.util.List;

public class Bill {
    private String id;
    private Table table;
    private List<MenuItem> consumedItems;
    Boolean paid;
    
private final static 

    public Bill(String id, Table table, List<MenuItem> consumedItems, boolean paid) {
        this.id = id;
        this.table = table;
        this.consumedItems = consumedItems;
        this.paid = paid;
    }

    ///// BASIC GETTERS AND SETTERS /////
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        if (paid == null) {
            throw new IllegalArgumentException("The paid field cannot be empty.");
        }
        this.paid = paid;
    }

    ///// DOMAIN METHODS /////
    private String getPrefix() {
        return "BILL";
    }
    
    
}
