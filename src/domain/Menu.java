package domain;

import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
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
            if (item.getId() == id) {
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
