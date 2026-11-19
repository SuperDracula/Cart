package model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<LineItem> items;
    
    public Cart(ArrayList<LineItem> items) {
        this.items = items;
    }

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public void addItems(LineItem item) {
        if (items.isEmpty()) {
            items.add(item);
        } else {
            boolean flag = false;
            for (LineItem i : items) {
                if (i.getProduct().getId().equals(item.getProduct().getId())) {
                    i.setQuantity(i.getQuantity() + 1);
                    flag = true;
                }
            }
            if (!flag) {
                items.add(item);
            }
        }
    }

    public void removeItems(String productId) {
        for (LineItem i : items) {
            if (i.getProduct().getId().equals(productId)) {
                items.remove(i);
            }
        }
    }

    public void updateItems(String productId, int quantity) {
        for (LineItem i : items) {
            if (i.getProduct().getId().equals(productId)) {
                i.setQuantity(quantity);
            }
        }
    }
}