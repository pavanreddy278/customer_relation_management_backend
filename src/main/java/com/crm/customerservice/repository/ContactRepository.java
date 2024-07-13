package com.crm.customerservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.customerservice.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	Optional<Contact> findByEmail(String email);	
}
