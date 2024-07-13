package com.crm.customerservice.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.repository.ContactRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
    private ContactRepository contactRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Contact> contactOptional = contactRepository.findByEmail(email);
        Contact contact = contactOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(contact.getEmail(), contact.getPassword(), new ArrayList<>());
    }
}
