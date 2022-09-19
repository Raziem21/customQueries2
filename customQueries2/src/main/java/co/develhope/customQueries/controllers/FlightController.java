package co.develhope.customQueries.controllers;

import co.develhope.customQueries.EnumFlightStatus;
import co.develhope.customQueries.entities.Flight;
import co.develhope.customQueries.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {



    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/createAll")
    public void createFlights(@RequestParam(required = false) Integer n) {
        List<Flight> flights = new ArrayList<>();
        if(n == null) {
            for (n = 0; n < 100; n++) {
                byte[] array = new byte[7]; // length is bounded by 7
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));

                flights.add(n, new Flight(generatedString, generatedString, generatedString, EnumFlightStatus.randomEnum()));
            }
        } else {
            Integer m = n;
            for (n = 0; n < m; n++) {
                byte[] array = new byte[7]; // length is bounded by 7
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));

                flights.add(n, new Flight(generatedString, generatedString, generatedString, EnumFlightStatus.randomEnum()));
            }
        }
        flightRepository.saveAll(flights);
    }

/*
    @GetMapping("/createAll")
    public void createFlights() {
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i<50; i++) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));

            flights.add(i, new Flight(generatedString, generatedString, generatedString, EnumFlightStatus.ONTIME));
        }
        flightRepository.saveAll(flights);
    }
*/
    @PostMapping
    public Flight create(@RequestBody Flight flight) {
        Flight flightSaved = flightRepository.saveAndFlush(flight);
        return flightSaved;
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlight(@PathVariable long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        return flight;
    }

    @GetMapping("/viewAll")
    public List<Flight> getAllFlight() {
        List<Flight> allFlight = flightRepository.findAll();
        return allFlight;
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable long id, @RequestBody Flight flight) {
        flight.setId(id);
        Flight flightUpdated = flightRepository.saveAndFlush(flight);
        return flightUpdated;
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable long id) {
        flightRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllFlights(@RequestParam List<Long> ids) {
        flightRepository.deleteAllById(ids);
    }
}
