//package com.example.CRManagement;
//
//public interface InteractionRepository {
//}

package com.example.CRManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
    List<Interaction> findByCustomerId(Long customerId);
}
