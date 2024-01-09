package com.jbpark03.ch17newfeature.register;

import org.springframework.context.ApplicationEvent;

import com.jbpark03.ch17newfeature.model.Passenger;

import lombok.Getter;

@Getter
public class PassengerRegisterEvent extends ApplicationEvent{
  private Passenger passenger;
  
  public PassengerRegisterEvent(Passenger passenger) {
    super(passenger);
    this.passenger = passenger;
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

}
