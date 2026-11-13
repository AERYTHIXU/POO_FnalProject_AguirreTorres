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
        return tables;
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
        Table newTable = new PermanentTable(numericId, capacity, name);
        if (searchTablebyId(newTable.getId()) != null) {
            throw new IllegalArgumentException("A table with this ID already exists.");
        }
        tables.add(newTable);
    }

    public void createTemporaryTable(int numericId, int capacity, String note) {
        Table newTable = new TemporaryTable(numericId, capacity, note);
        if (searchTablebyId(newTable.getId()) != null) {
            throw new IllegalArgumentException("A table with this ID already exists.");
        }
        tables.add(newTable);
    }

    public Table searchTablebyId(String id) {
        for (Table table : tables) {
            if (table.getId().equalsIgnoreCase(id)) {
                return table;
            }
        }
        return null;
    }

    public void removeTableById(String id) {
        Table table = searchTablebyId(id);
        if (table == null) {
            throw new IllegalArgumentException("there is no table with this ID.");
        }
    }
}
