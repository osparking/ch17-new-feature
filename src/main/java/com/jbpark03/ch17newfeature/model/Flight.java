package com.jbpark03.ch17newfeature.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public class Flight {
  private String fligheNumber;
  private int seats;
  private Set<Passenger> passengers = new HashSet<>();

  public Flight(String fligheNumber, int seats) {
    super();
    this.fligheNumber = fligheNumber;
    this.seats = seats;
  }
  
  public Set<Passenger> getPassengers() {
    return Collections.unmodifiableSet(passengers);
  }

  @Override
  public String toString() {
    return "항공편 [번호=" + fligheNumber + "]";
  }
  
  public boolean addPassenger(Passenger passenger) {
    if (passengers.size() >= seats) {
      throw new RuntimeException("좌석 부족으로 탑승이 거부되었습니다.");
    }
    return passengers.add(passenger);
  }
}
