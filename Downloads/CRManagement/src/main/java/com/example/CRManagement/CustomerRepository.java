//package com.example.CRManagement;
//
//public interface CustomerRepository {
//}
package com.example.CRManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query if needed: Optional<Customer> findByEmail(String email);
}
