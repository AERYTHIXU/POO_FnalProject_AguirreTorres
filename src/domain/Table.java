package domain;

public class Table {
    public enum TableStatus {
        AVAIBLE,
        OCCUPIED
    }

    private int id;
    private int capacity;
    private TableStatus status;

    public Table(int id, int capacity) {
        setId(id);
        setCapacity(capacity);
    }

    ///// BASIC GETTERS AND SETTERS //////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Table ID must be greater than 0.");
        }
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Table capacity must be greater than 0.");
        }
        this.capacity = capacity;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
}
