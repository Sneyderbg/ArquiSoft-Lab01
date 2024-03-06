package com.udea.vuelo.service;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.vuelo.model.Flight;

@Service
public class FlightService {

    private final String filePath = "flights.json";

    public List<List<Flight>> searchFlights(LocalDate startDate, LocalDate endDate) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream fileStream = getClass().getClassLoader().getResourceAsStream(filePath);
            if (fileStream != null) {
                Flight[] flights = objectMapper.readValue(fileStream, Flight[].class);
                return Arrays.asList(Arrays.stream(flights)
                        .filter(flight -> isDateInRange(flight.getDepartureDate(), startDate, endDate))
                        .collect(Collectors.toList()));
            } else {
                throw new Exception("database file cannot be loaded.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    // -------------------------------------- utils --------------------------------------
    // -----------------------------------------------------------------------------------
    public boolean isDateInRange(LocalDate date, LocalDate start, LocalDate end) {
        // return (date.compareTo(start) >= 0 && date.compareTo(end) <= 0);
        return (date.isAfter(start) && date.isBefore(end));
    }
}