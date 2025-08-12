//package com.example.CRManagement;
//
//public class Interaction {
//}

package com.example.CRManagement;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., Call, Email, Meeting

    @Column(length = 500)
    private String notes;

    private LocalDateTime interactionDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Interaction() {
        this.interactionDate = LocalDateTime.now();
    }

    public Interaction(String type, String notes, Customer customer) {
        this.type = type;
        this.notes = notes;
        this.customer = customer;
        this.interactionDate = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getInteractionDate() {
        return interactionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
