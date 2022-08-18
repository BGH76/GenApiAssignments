package com.example.ContactList.contact;

import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactRepo implements ContactDAO{

    public List<Contact> getListOfContacts() {
        return buildListOfContacts();
    }

    public void addNewContact(Contact contact) {
        List<Contact> temp = buildListOfContacts();
        temp.add(contact);
        saveListOfContacts(temp);
    }

    public void updateContact(Contact contact, Integer id) {
        List<Contact> list = buildListOfContacts();
        list.removeIf(e -> e.getId()==id);
        list.add(contact);
        saveListOfContacts(list);
    }
    public void deleteContact(Integer id) {
        List<Contact> list = buildListOfContacts();
        list.removeIf(e -> e.getId() == id);
        saveListOfContacts(list);
    }

    public List<Contact> buildListOfContacts() {
        try {
            List<Contact> temp = Files.readAllLines(Paths.get("contacts.txt"))
                    .stream()
                    .map(m -> m.split(","))
                    .map(c -> new Contact(Integer.parseInt(c[0]), c[1], c[2], c[3], c[4]))
                    .collect(Collectors.toList());
            return temp;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveListOfContacts(List<Contact> list) {
        File file = new File("contacts.txt");
        try {
            FileWriter fw = new FileWriter(file);
            list.forEach(e -> {
                try {
                    fw.write(e.getId() + "," + e.getName() + "," + e.getEmail() + "," + e.getAddress() + "," + e.getPhoneNumber() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            fw.close();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
