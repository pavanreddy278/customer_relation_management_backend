package com.crm.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.repository.ContactRepository;

@Service
public class CustomerService {
	    @Autowired
	    private ContactRepository contactRepository;

	    public List<Contact> getAllContacts() {
	        return contactRepository.findAll();
	    }

	    public Contact getContactById(Long id) {
	        return contactRepository.findById(id).orElse(null);
	    }

	    public Contact createContact(Contact contact) {
	        return contactRepository.save(contact);
	    }

	    public Contact updateContact(Long id, Contact contact) {
	        contact.setId(id);
	        return contactRepository.save(contact);
	    }

	    public void deleteContact(Long id) {
	        contactRepository.deleteById(id);
	    }

		public Optional<Contact> findByEmail(String name) {
			// TODO Auto-generated method stub
			return contactRepository.findByEmail(name);
		}
}
