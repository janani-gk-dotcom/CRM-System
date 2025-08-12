package com.example.CRManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setCompany(updatedCustomer.getCompany());
            customer.setStatus(updatedCustomer.getStatus());
            return customerRepository.save(customer);
        }).orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public String calculateEngagementStatus(Customer customer) {
        List<Interaction> recentInteractions = customer.getInteractions().stream()
                .filter(i -> i.getInteractionDate().isAfter(LocalDateTime.now().minusDays(30)))
                .collect(Collectors.toList());

        int count = recentInteractions.size();

        if (count >= 8) return "Highly Engaged";
        else if (count >= 4) return "Moderately Engaged";
        else return "At Risk";
    }

    public void updateAllCustomerEngagementStatus() {
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            String status = calculateEngagementStatus(customer);
            customer.setStatus(status);
        }

        customerRepository.saveAll(customers);
    }
    public List<Customer> getCustomersByStatus(String status) {
        return customerRepository.findAll().stream()
                .filter(c -> status.equalsIgnoreCase(c.getStatus()))
                .collect(Collectors.toList());
    }

}
