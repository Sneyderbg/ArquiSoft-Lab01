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
    private Flight[] flights;

    public FlightService() {
        try {

            InputStream fileStream = getClass().getClassLoader().getResourceAsStream(filePath);
            ObjectMapper objectMapper = new ObjectMapper();
            flights = objectMapper.readValue(fileStream, Flight[].class);
            if (fileStream == null) {
                throw new Exception("database file cannot be loaded.");
            }
        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Flight> searchFlightsByDate(LocalDate startDate, LocalDate endDate) {

        return Arrays.stream(flights)
                .filter(flight -> isDateInRange(flight.getDepartureDate(), startDate, endDate))
                .collect(Collectors.toList());

    }

    // Funcion que se encarga de filtrar los vuelos por precio
    public List<Flight> searchFlightsByPrice(int inicialPrice, int finalPrice) {
        return Arrays.stream(flights)
                .filter(flight -> isPriceInRange(flight.getPrice(), inicialPrice, finalPrice))
                .collect(Collectors.toList());
    }

    // Funcion que se encarga de Buscar los vuelos por nombre de la aerolinea
    public List<Flight> searchFlightsByName(String nameAirline) {

        return Arrays.stream(flights)
                .filter(flight -> flight.getAirline().equalsIgnoreCase(nameAirline))
                .collect(Collectors.toList());

    }

    public List<Flight> searchFlightsByDestination(String placeOfDestination) {

        return Arrays.stream(flights)
                .filter(flight -> flight.getDestination().equalsIgnoreCase(placeOfDestination))
                .collect(Collectors.toList());

    }

    public List<Flight> searchFlightsByOrigin(String placeofOrigin) {

        return Arrays.stream(flights)
                .filter(flight -> flight.getOrigin().equalsIgnoreCase(placeofOrigin))
                .collect(Collectors.toList());

    }

    // -------------------------------- utils --------------------------------
    // -----------------------------------------------------------------------
    public boolean isDateInRange(LocalDate date, LocalDate start, LocalDate end) {
        // return (date.compareTo(start) >= 0 && date.compareTo(end) <= 0);
        return (date.isAfter(start) && date.isBefore(end));
    }

    public boolean isPriceInRange(int price, int priceInicial, int priceFinal) {
        return (price >= priceInicial && price <= priceFinal);
    }

}
