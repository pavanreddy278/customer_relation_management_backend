package com.crm.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.SupportTicket;
import com.crm.customerservice.repository.SupportTicketRepository;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    public List<SupportTicket> getSupportTicketsByContact(Contact contact) {
        return supportTicketRepository.findByContact(contact);
    }

    public SupportTicket getSupportTicketById(Long id) {
        Optional<SupportTicket> supportTicket = supportTicketRepository.findById(id);
        return supportTicket.orElse(null);
    }

    public SupportTicket createSupportTicket(SupportTicket supportTicket) {
        return supportTicketRepository.save(supportTicket);
    }

    public SupportTicket updateSupportTicket(Long id, SupportTicket updatedSupportTicket) {
        Optional<SupportTicket> existingSupportTicketOptional = supportTicketRepository.findById(id);
        if (existingSupportTicketOptional.isPresent()) {
            SupportTicket existingSupportTicket = existingSupportTicketOptional.get();
            existingSupportTicket.setIssue(updatedSupportTicket.getIssue());
            existingSupportTicket.setStatus(updatedSupportTicket.getStatus());
            existingSupportTicket.setOpened(updatedSupportTicket.getOpened());
            existingSupportTicket.setContact(updatedSupportTicket.getContact());
            return supportTicketRepository.save(existingSupportTicket);
        } else {
            return null;
        }
    }

    public void deleteSupportTicket(Long id) {
        supportTicketRepository.deleteById(id);
    }
}
