//package com.example.CRManagement;
//
//public class InteractionController {
//}

package com.example.CRManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @GetMapping
    public List<Interaction> getAllInteractions() {
        return interactionService.getAllInteractions();
    }

    @GetMapping("/customer/{customerId}")
    public List<Interaction> getByCustomerId(@PathVariable Long customerId) {
        return interactionService.getInteractionsByCustomerId(customerId);
    }

    @GetMapping("/{id}")
    public Optional<Interaction> getById(@PathVariable Long id) {
        return interactionService.getInteractionById(id);
    }

    @PostMapping
    public Interaction addInteraction(@RequestBody Interaction interaction) {
        return interactionService.saveInteraction(interaction);
    }

    @DeleteMapping("/{id}")
    public void deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
    }
}
