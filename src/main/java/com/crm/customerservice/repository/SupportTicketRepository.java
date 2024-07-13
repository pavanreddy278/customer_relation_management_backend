package com.crm.customerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.SupportTicket;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, Long> {

	List<SupportTicket> findByContact(Contact contact);
}
