package com.nisha.spring.finalex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisha.spring.finalex.model.Reservation;
import com.nisha.spring.finalex.repository.ReservationRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationRepository repo;
    private final ObjectMapper objectMapper;

    public ReservationRestController(ReservationRepository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    // Create new reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation saved = repo.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all reservations
    @GetMapping
    public List<Reservation> getAllReservations() {
        return repo.findAll();
    }

    // Get reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Optional<Reservation> found = repo.findById(id);
        return found.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id, @RequestBody Reservation updatedData) {
        Optional<Reservation> existingReservation = repo.findById(id);

        if (existingReservation.isPresent()) {
            Reservation reservation = updatedData;
            reservation.setId(id); 
            Reservation updatedReservation = repo.save(reservation);
            return ResponseEntity.ok(updatedReservation);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
