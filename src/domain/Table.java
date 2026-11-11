package domain;

public abstract class Table {
    public enum TableStatus {
        AVAIBLE,
        OCCUPIED,
        RESERVED
    }

    private int capacity;
    private TableStatus status;

    public Table(int id, int capacity) {
        setCapacity(capacity);
        setStatus(TableStatus.AVAIBLE);
    }

    ///// BASIC GETTERS AND SETTERS //////

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

    ////// DOMAIN METHODS /////
    public boolean isAvaible() {
        return this.status == TableStatus.AVAIBLE;
    }

    public abstract String getTableType();
}
