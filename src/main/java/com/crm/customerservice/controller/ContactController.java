package com.crm.customerservice.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.service.CustomerService;

@RestController
@RequestMapping("/api/crm/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return customerService.getAllContacts();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return customerService.createContact(contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return customerService.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return customerService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        customerService.deleteContact(id);
    }

    @GetMapping("/me")
    public Optional<Contact> getMyDetails(Contact principal) {
        return customerService.findByEmail(principal.getEmail());
    }
}
