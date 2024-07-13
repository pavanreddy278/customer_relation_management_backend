package com.crm.customerservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByContact(Contact contact);

	List<Task> findAll();
}
