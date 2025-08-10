package com.example.poems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/poems")
public class PoemController {

    @Autowired
    private PoemService poemService;

    // Health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Poem service is up and running!");
    }

    // Get all poems
    @GetMapping
    public ResponseEntity<List<Poem>> getAllPoems() {
        return ResponseEntity.ok(poemService.getAllPoems());
    }

    // Create a new poem
    @PostMapping
    public ResponseEntity<Poem> createPoem(@RequestBody Poem poem) {
        Poem createdPoem = poemService.createPoem(poem);
        return ResponseEntity.ok(createdPoem);
    }

    // Update an existing poem
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoem(@PathVariable Long id, @RequestBody Poem poem) {
        Optional<Poem> updatedPoem = poemService.updatePoem(id, poem);
        return updatedPoem
                .map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a poem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoem(@PathVariable Long id) {
        poemService.deletePoem(id);
        return ResponseEntity.noContent().build();
    }
}

