package com.crm.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.SupportTicket;
import com.crm.customerservice.service.CustomerService;
import com.crm.customerservice.service.SupportTicketService;

@RestController
@RequestMapping("/api/crm/support-ticket")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportTicketController {

    @Autowired
    private SupportTicketService supportTicketService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketService.getAllSupportTickets();
    }

    @GetMapping("/{ticketId}")
    public SupportTicket getSupportTicketById(@PathVariable Long ticketId) {
        return supportTicketService.getSupportTicketById(ticketId);
    }

    @GetMapping("/contact/{contactId}")
    public List<SupportTicket> getSupportTicketsByContact(@PathVariable Long contactId) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            return supportTicketService.getSupportTicketsByContact(contact);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @PostMapping("/contact/{contactId}")
    public SupportTicket createSupportTicket(@PathVariable Long contactId, @RequestBody SupportTicket supportTicket) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            supportTicket.setContact(contact);
            return supportTicketService.createSupportTicket(supportTicket);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @PutMapping("/{ticketId}")
    public SupportTicket updateSupportTicket(@PathVariable Long ticketId, @RequestBody SupportTicket supportTicket) {
        return supportTicketService.updateSupportTicket(ticketId, supportTicket);
    }

    @DeleteMapping("/{ticketId}")
    public void deleteSupportTicket(@PathVariable Long ticketId) {
        supportTicketService.deleteSupportTicket(ticketId);
    }
}
