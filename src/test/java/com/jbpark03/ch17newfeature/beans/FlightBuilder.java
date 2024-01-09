package com.jbpark03.ch17newfeature.beans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.jbpark03.ch17newfeature.model.Country;
import com.jbpark03.ch17newfeature.model.Flight;
import com.jbpark03.ch17newfeature.model.Passenger;

@TestConfiguration
public class FlightBuilder {

  private static Map<String, Country> map = new HashMap<>();
  static {
    map.put("KR", new Country("대한민국", "KR"));
    map.put("JP", new Country("일본", "JP"));
    map.put("CN", new Country("중국", "CN"));
    map.put("AU", new Country("호주", "AU"));
    map.put("US", new Country("미국", "US"));
    map.put("UK", new Country("영국", "UK"));
  }

  @Bean
  Flight buildFlight() throws IOException {
    Flight flight = new Flight("KA12345", 10);

    try (BufferedReader reader = new BufferedReader(
        new FileReader("src/test/resources/passengers.csv"))) {
      String line = null;

      do {
        if ((line = reader.readLine()) == null) {
          break;
        } else {
          String[] passengerString = line.toString().split(";");
          Passenger passenger = new Passenger(passengerString[0].trim(),
              map.get(passengerString[1].trim()), false);
          flight.addPassenger(passenger);
        }
      } while (true);

      return flight;
    }
  }
}
