package com.nisha.spring.finalex.repository;

import com.nisha.spring.finalex.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
	
}
