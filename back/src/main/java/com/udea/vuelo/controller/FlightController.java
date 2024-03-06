package com.udea.vuelo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udea.vuelo.model.Flight;
import com.udea.vuelo.service.FlightService;

@RestController()
@RequestMapping(path = "/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<List<Flight>> searchFlights(@RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate) {
                LocalDate start = LocalDate.parse(startDate);
                LocalDate end = LocalDate.parse(endDate);
                return flightService.searchFlights(start, end);
    }
    @GetMapping("/searchByName")
    public List<List<Flight>> searchFlightsByName(@RequestParam(name = "nombreAerolinea") String nombreAerolinea) {

        return flightService.searchFlightsByName(nombreAerolinea);
    }
}
