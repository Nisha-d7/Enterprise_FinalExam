package com.nisha.spring.finalex.controller;
import com.nisha.spring.finalex.model.Reservation;
import com.nisha.spring.finalex.repository.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationWebController {
	private final ReservationRepository repo;

    public ReservationWebController(ReservationRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation_form";
    }

    @PostMapping("/submit")
    public String submitForm(Reservation reservation) {
        repo.save(reservation);
        return "success";
    }

}
