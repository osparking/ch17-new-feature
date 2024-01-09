package com.jbpark03.ch17newfeature.register;

import org.springframework.context.event.EventListener;

public class PassengerRegisterListener {

  @EventListener
  void processPassengerRegister(PassengerRegisterEvent event) {
    var passenger = event.getPassenger();
    passenger.setRegistered(true);
    System.out.println("등록 후 승객 정보: " + passenger);
  }
}
