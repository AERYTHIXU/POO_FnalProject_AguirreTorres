package domain;

import java.util.ArrayList;
import java.util.List;

import util.IdManager;

public abstract class Table {

    public enum TableStatus {
        AVAILABLE,
        OCCUPIED,
        RESERVED
    }

    protected String id;
    private int capacity;
    private TableStatus status;

    private static final List<String> existingIds = new ArrayList<>();

    public Table(int capacity) {
        setCapacity(capacity);
        setStatus(TableStatus.AVAILABLE);
    }

    ///// BASIC GETTERS AND SETTERS //////

    public String getId() {
        return id;
    }
    public void setId(int numericId) {
        this.id = IdManager.generateAndRegisterId(numericId, getPrefix(), this.getId(), existingIds);
    }

    public static void unregisterId(String id) {
        existingIds.remove(id);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Table capacity must be greater than 0.");
        }
        this.capacity = capacity;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Table status cannot be null");
        }
        this.status = status;
    }
    
    ///// DOMAIN METHODS /////
    public boolean isAvailable() {
        return this.getStatus() == TableStatus.AVAILABLE;
    }

    protected abstract String getPrefix();
    public abstract String getTableType();

    
}
