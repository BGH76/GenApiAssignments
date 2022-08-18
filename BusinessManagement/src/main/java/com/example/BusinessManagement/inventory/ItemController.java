package com.example.BusinessManagement.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/inventory")
@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(path = "{itemNumber}")
    public Item getItem(@PathVariable("itemNumber") String itemNumber) {
        return itemService.getItem(itemNumber);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getItem();
    }

    @GetMapping(path = "/current")
    public List<String> getCurrentInventory() {
        return itemService.getCurrentInventory();
    }

    @PostMapping
    public void addNewItem(@RequestBody Item item) {
        itemService.addNewItem(item);
    }

    @PutMapping(path = "{itemNumber}")
    public void updateItem(@PathVariable("itemNumber") String itemNumber, String itemName, int itemQuantity, double itemPrice, int min, int max) {
        itemService.updateItem(itemNumber, itemName, itemQuantity, itemPrice, min, max);
    }

    @DeleteMapping(path = "{itemNumber}")
    public void deleteItem (@PathVariable("itemNumber") String itemNumber) {
        itemService.deleteItem(itemNumber);
    }
}
