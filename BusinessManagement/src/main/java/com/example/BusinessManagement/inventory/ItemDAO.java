package com.example.BusinessManagement.inventory;

import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemDAO {

    public List<Item> getData() {
        try {
            List<Item> inventoryData = Files.readAllLines(Paths.get("Inventory.txt"))
                    .stream()
                    .map(m -> m.split(","))
                    .map(e -> new Item(e[0], e[1], Integer.parseInt(e[2]), Double.parseDouble(e[3]), Integer.parseInt(e[4]), Integer.parseInt(e[5])))
                    .collect(Collectors.toList());
            return inventoryData;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveData(List<Item> list) {
        try {
            PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("Inventory.txt")));
            list.stream()
                    .map(m -> String.format("%s,%s,%s,%s,%s,%s",
                            m.getItemNumber(),
                            m.getItemName(),
                            m.getItemQuantity(),
                            m.getItemPrice(),
                            m.getMin(),
                            m.getMax()))
                    .forEach(pw::println);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
