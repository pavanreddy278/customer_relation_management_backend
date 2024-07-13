package com.crm.customerservice.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="_sale")
public class Sale {
	@Id
    @GeneratedValue
    private Long id;
    private String product;
    private BigDecimal amount;
    private LocalDate date;
    
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

	}
