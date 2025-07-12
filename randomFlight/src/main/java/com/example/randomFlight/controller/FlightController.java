package com.example.randomFlight.controller;

import com.example.randomFlight.model.Flight;
import com.example.randomFlight.model.Status;
import com.example.randomFlight.repository.FlightRepository;
import com.example.randomFlight.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepo ;
    private final Random random = new Random();

    @GetMapping
    public List<Flight> findAll() {
        return  flightRepo.findAll() ;
    }

    @PostMapping
    public String createFlight() {

        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight(

                    RandomUtils.randomString(150),
                    RandomUtils.randomString(5),
                    RandomUtils.randomString(2),
                    Status.ONTIME
            );
            flightRepo.save(flight);
        }
        return "Voli aggiunti";
    }
    }


