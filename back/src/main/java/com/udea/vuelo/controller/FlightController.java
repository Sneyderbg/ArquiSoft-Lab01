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
    public List<Flight> searchFlightsByDate(@RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return flightService.searchFlightsByDate(start, end);
    }

    @GetMapping("/searchByPrice")
    public List<Flight> searchFlightsByPrice(@RequestParam(name = "inicialPrice") String inicialPrice,
            @RequestParam(name = "finalPrice") String finalPrice) {
        int precioInicial = Integer.parseInt(inicialPrice);
        int precioFinal = Integer.parseInt(finalPrice);
        return flightService.searchFlightsByPrice(precioInicial, precioFinal);
    }

    @GetMapping("/searchByName")
    public List<Flight> searchFlightsByName(@RequestParam(name = "nameAirline") String nameAirline) {

        return flightService.searchFlightsByName(nameAirline);
    }

    @GetMapping("/searchByOrigin")
    public List<Flight> searchFlightsByOrigin(@RequestParam(name = "cityOfOrigin") String cityOfOrigin) {

        return flightService.searchFlightsByOrigin(cityOfOrigin);
    }

    @GetMapping("/searchByDestination")
    public List<Flight> searchFlightsByDestination(
            @RequestParam(name = "cityOfDestination") String cityOfDestination) {

        return flightService.searchFlightsByDestination(cityOfDestination);
    }

}
