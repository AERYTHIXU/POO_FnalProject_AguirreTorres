package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    /////MENU ITEM CRUD /////   
    public void addItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("The item cannot be empty");
        }
        items.add(item);
    }

    public MenuItem searchItemById(String id) {
        for (MenuItem item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public List<MenuItem> getAllItems() {
        return items;
    }

    public boolean removeItem(String id) {
        MenuItem item = searchItemById(id); {
            if (item!= null) {
                items.remove(item);
                return true;
            }
            return false;
        }
    }
}
