package com.example.ContactList.contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> getListOfContacts();
    void addNewContact(Contact contact);
    void updateContact(Contact contact, Integer id);
    void deleteContact(Integer id);
    List<Contact> buildListOfContacts();
    void saveListOfContacts(List<Contact> list);
}
