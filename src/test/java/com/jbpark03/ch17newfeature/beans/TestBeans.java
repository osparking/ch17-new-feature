package com.jbpark03.ch17newfeature.beans;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.jbpark03.ch17newfeature.model.Country;
import com.jbpark03.ch17newfeature.model.Passenger;

@TestConfiguration
public class TestBeans {
  @Bean
  Passenger createTestPassenger() {
    var passenger = new Passenger("김철수", createTestCountry(), false);
    return passenger;
  }
  
  @Bean
  Country createTestCountry() {
    return new Country("대한민국", "KR");
  }
}
