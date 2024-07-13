package com.crm.customerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	List<Sale> findByContact(Contact contact);

}
