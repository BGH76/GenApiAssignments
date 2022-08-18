package com.example.BusinessManagement.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    public List<Item> getItem() {
        return itemDAO.getData();
    }

    public Item getItem(String item) {
        List<Item> temp = itemDAO.getData()
                .stream()
                .filter(f -> f.getItemNumber().equals(item))
                .toList();
        return temp.size() > 0 ? temp.get(0):null;
    }

    public List<String> getCurrentInventory() {
        List<String> temp = itemDAO.getData()
                .stream()
                .map(m -> m.getItemName() + " : " + m.getItemQuantity()).toList();
        return temp;
    }

    public void addNewItem(Item item) {
        List<Item> temp = itemDAO.getData();
        temp.add(item);
        itemDAO.saveData(temp);
    }

    public void updateItem(String number, String name, int quantity, double price, int min, int max) {
        List<Item> temp = itemDAO.getData();
        temp.forEach(e -> {
            if(e.getItemNumber().equals(number)) {
                e.setItemName(name);
                e.setItemQuantity(quantity);
                e.setItemPrice(price);
                e.setMin(min);
                e.setMax(max);
            }
        });
        itemDAO.saveData(temp);
    }

    public void deleteItem(String itemNumber) {
        List<Item> temp = itemDAO.getData();
        temp.removeIf(e -> e.getItemNumber().equals(itemNumber));
        itemDAO.saveData(temp);
    }

}
