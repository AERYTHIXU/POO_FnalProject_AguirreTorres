package domain;

import java.util.ArrayList;
import java.util.List;

import util.IdManager;

public class Bill {

    public enum BillStatus {
        PENDING,
        PAID,
    }

    private String id;
    private Table table;
    private List<MenuItem> consumedItems;
    private BillStatus status;

    private final static String PREFIX = "BLL";

    private static final ArrayList<String> existingBillIds = new ArrayList<>();

    public Bill(int numericId, Table table) {
        setId(numericId);
        setTable(table);
        this.consumedItems = new ArrayList<>(); 
        this.status = BillStatus.PENDING; 
    }

    ///// BASIC GETTERS Y SETTERS /////
    public String getId() {
        return id;
    }

    public void setId(int numericId) {
        this.id = IdManager.generateAndRegisterId(numericId, PREFIX, this.getId(), existingBillIds);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        if (table == null) {
            throw new IllegalArgumentException("Bill must be associated whit a table.");
        }
        this.table = table;
    }

    public List<MenuItem> getConsumedItems() {
        return  new ArrayList<>(consumedItems);
    }

    public BillStatus getStatus() {
        return status;
    }
    public void setStatus(BillStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Bill Status cannot be null.");
        }
        this.status = status;
    }

    ///// CONSUMED ITEMS CRUD /////
    public void addConsumedItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("The item to be added cannot be empty.");
        } if (this.getStatus() == BillStatus.PAID) {
            throw new IllegalArgumentException("Cannot add items to a bill that is already paid");
        }
        consumedItems.add(item);
    }

    public void removeItem(MenuItem item) {
        if (!consumedItems.remove(item)) {
            throw new IllegalArgumentException("Item not found in this bill");
        }
    }

    ///// DOMAIN METHODS) /////
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : consumedItems) {
            total += item.getPrice();
        }
        return total;
    }

    public void payBill() {
        if (this.getStatus() == BillStatus.PAID) {
            throw new IllegalArgumentException("This bill has already been paid.");
        }
        this.setStatus(BillStatus.PAID);

        if (this.table != null) {
            this.table.setStatus(Table.TableStatus.AVAILABLE);
        }
    }

}