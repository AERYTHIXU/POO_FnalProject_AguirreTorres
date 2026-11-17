package domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Table> tables;
    private Menu menu;
    
    public Restaurant(String name) {
        setName(name);
        this.tables = new ArrayList<>();
        this.menu = new Menu();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Restaurant name cannot be empty.");
        }
        this.name = name;
    }

    public List<Table> getTables() {
        return new ArrayList<>(tables);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Menu field cannot be empty.");
        }
        this.menu = menu;
    }

    ///// TABLES CRUD /////
    
    public void createPermanentTable(int numericId, int capacity)  {
        Table newTable = new PermanentTable(numericId, capacity);
        if (searchTableById(newTable.getId()) != null) {
            throw new IllegalArgumentException("A table with this ID already exists.");
        }
        tables.add(newTable);
    }

    public void createTemporaryTable(int numericId, int capacity, String note) {
        Table newTable = new TemporaryTable(numericId, capacity, note);
        if (searchTableById(newTable.getId()) != null) {
            throw new IllegalArgumentException("A table with this ID already exists.");
        }
        tables.add(newTable);
    }

    public Table searchTableById(String id) {
        for (Table table : tables) {
            if (table.getId().equalsIgnoreCase(id)) {
                return table;
            }
        }
        return null;
    }

    public void removeTableById(String id) {
        Table table = searchTableById(id);
        if (table == null) {
            throw new IllegalArgumentException("There is no table with this ID.");
        }
        Table.unregisterId(table.getId());
        tables.remove(table);
    }

    ///// TABLE OPERATIONS /////
    
    public void occupyTable(String id) {
        Table table = searchTableById(id);
        if (table == null) {
            throw new IllegalArgumentException("There is no table with this ID.");
        }
        if (!table.isAvailable()) {
            throw new IllegalStateException("Table is already occupied or reserved.");
        }
        table.setStatus(Table.TableStatus.OCCUPIED);
    }

    public void freeTable(String id) {
        Table table = searchTableById(id);
        if (table == null) {
            throw new IllegalArgumentException("There is no table with this ID.");
        }
        table.setStatus(Table.TableStatus.AVAILABLE);
    }

    public List<Table> getAvailableTables() {
        List<Table> available = new ArrayList<>();
        for (Table table : tables) {
            if (table.isAvailable()) {
                available.add(table);
            }
        }
        return available;
    }
}
