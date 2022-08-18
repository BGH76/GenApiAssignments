package com.example.ContactList.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getListOfContacts() {
        return contactService.getListOfContacts();
    }

    @PostMapping
    public void addNewContact(@RequestBody Contact contact) {
        contactService.addNewContact(contact);
    }

    @PutMapping(path = "{contactId}")
    public void updateContact(@PathVariable("contactId") Integer id, String name, String address, String email, String phoneNumber) {
        contactService.updateContact(id, name, address, email, phoneNumber);
    }

    @DeleteMapping(path = "{contactId}")
    public void deleteContact(@PathVariable("contactId") Integer id) {
        contactService.deleteContact(id);
    }
}
