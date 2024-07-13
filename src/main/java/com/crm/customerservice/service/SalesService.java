package com.crm.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Sale;
import com.crm.customerservice.repository.SaleRepository;

@Service
public class SalesService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getSalesByContact(Contact contact) {
        return saleRepository.findByContact(contact);
    }

    public Sale getSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.orElse(null);
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale updateSale(Long id, Sale updatedSale) {
        Optional<Sale> existingSaleOptional = saleRepository.findById(id);
        if (existingSaleOptional.isPresent()) {
            Sale existingSale = existingSaleOptional.get();
            existingSale.setProduct(updatedSale.getProduct());
            existingSale.setAmount(updatedSale.getAmount());
            existingSale.setDate(updatedSale.getDate());
            existingSale.setContact(updatedSale.getContact());
            return saleRepository.save(existingSale);
        } else {
            return null; // Or throw an exception as per your error handling strategy
        }
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
    
    
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
}
