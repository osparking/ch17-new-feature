package com.jbpark03.ch17newfeature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.jbpark03.ch17newfeature.beans.FlightBuilder;
import com.jbpark03.ch17newfeature.model.Flight;
import com.jbpark03.ch17newfeature.register.PassengerRegisterEvent;
import com.jbpark03.ch17newfeature.register.RegisterManager;

@SpringBootTest
@Import(FlightBuilder.class)
class FlightTest {
  
  @Autowired
  private Flight flight; 
  
  @Autowired
  private RegisterManager manager;

  @Test
  void testAllPassengersRegister() {
    flight.getPassengers().forEach(p -> {
      System.out.println("승객 등록 전: " + p.toString());
      assertFalse(p.isRegistered());
      manager.getContext().publishEvent(new PassengerRegisterEvent(p));
      assertTrue(p.isRegistered());
    });
  }
}
