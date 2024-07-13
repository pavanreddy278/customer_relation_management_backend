package com.crm.customerservice.model;

import java.util.Date;

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
@Entity(name="_supportTicket")
public class SupportTicket {
	    @Id
	    @GeneratedValue
	    private Long id;
	    private String issue;
	    private String status;
	    private Date opened;
	    
	    @ManyToOne
	    @JoinColumn(name = "contact_id")
	    private Contact contact;

			    
}
