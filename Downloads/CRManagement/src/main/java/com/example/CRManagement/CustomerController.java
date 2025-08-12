//package com.example.CRManagement;
//
//public class CustomerController {
//}
package com.example.CRManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
    @PutMapping("/update-engagement-status")
    public String updateEngagementStatus() {
        customerService.updateAllCustomerEngagementStatus();  // ✅ instance method, not static
        return "Engagement statuses updated successfully.";
    }
    @GetMapping("/highly-engaged")
    public List<Customer> getHighlyEngagedCustomers() {
        return customerService.getCustomersByStatus("Highly Engaged");
    }


}
