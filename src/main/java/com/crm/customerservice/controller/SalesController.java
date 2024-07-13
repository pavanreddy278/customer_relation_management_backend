package com.crm.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Sale;
import com.crm.customerservice.service.CustomerService;
import com.crm.customerservice.service.SalesService;

@RestController
@RequestMapping("/api/crm/sales")
@CrossOrigin(origins = "http://localhost:3000")
public class SalesController {

    @Autowired
    private SalesService saleService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/contact/{contactId}")
    public List<Sale> getSalesByContact(@PathVariable Long contactId) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            return saleService.getSalesByContact(contact);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @GetMapping("/{saleId}")
    public Sale getSaleById(@PathVariable Long saleId) {
        return saleService.getSaleById(saleId);
    }

    @PostMapping("/contact/{contactId}")
    public Sale createSale(@PathVariable Long contactId, @RequestBody Sale sale) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            sale.setContact(contact);
            return saleService.createSale(sale);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @PutMapping("/{saleId}")
    public Sale updateSale(@PathVariable Long saleId, @RequestBody Sale sale) {
        return saleService.updateSale(saleId, sale);
    }

    @DeleteMapping("/{saleId}")
    public void deleteSale(@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }
}
