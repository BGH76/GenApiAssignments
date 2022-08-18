package com.example.ContactList.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private ContactDAO contactDAO;

    @Autowired
    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getListOfContacts() {
        return contactDAO.getListOfContacts();
    }

    public void addNewContact(Contact contact) {
        List<Contact> currentContacts = contactDAO.getListOfContacts();

        currentContacts.forEach(e -> {
            if(e.getName().equals(contact.getName())) {
                throw new IllegalStateException("Contact name already exists");
            }
            else if(e.getPhoneNumber().equals(contact.getPhoneNumber())) {
                throw new IllegalStateException("Phone number already in use");
            }
        });
        List<Integer> num = currentContacts
                .stream()
                .map(m -> m.getId())
                .collect(Collectors.toList());
        contact.setId(Collections.max(num)+1);
        contactDAO.addNewContact(contact);

    }

    public void updateContact(Integer id, String name, String address, String email, String phoneNumber) {
        List<Contact> contact = contactDAO.getListOfContacts()
                .stream()
                .filter(f -> f.getId().equals(id))
                .toList();
        if(contact.size() == 0) {
            throw new IllegalStateException("Invalid Id");
        }
        if(name != null && name.length() > 0 && !Objects.equals(contact.get(0).getName(), name)) {
            contact.get(0).setName(name);
        }
        if(address != null && address.length() > 0 && !Objects.equals(contact.get(0).getAddress(), address)) {
            contact.get(0).setAddress(address);
        }
        if(email != null && email.length() > 0 && !Objects.equals(contact.get(0).getEmail(), email)) {
            contact.get(0).setEmail(email);
        }
        if(phoneNumber != null && phoneNumber.length() > 0 && !Objects.equals(contact.get(0).getPhoneNumber(), phoneNumber)) {
            contact.get(0).setPhoneNumber(phoneNumber);
        }
        contactDAO.updateContact(contact.get(0), id);
    }

    public void deleteContact(Integer id) {
        List contact = contactDAO.getListOfContacts()
                .stream()
                .map(m -> m.getId())
                .toList();
        if(!contact.contains(id)) {
            throw new IllegalStateException("Invalid id number");
        }
        contactDAO.deleteContact(id);
    }
}
